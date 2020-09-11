package cn.michael.dev.spark.tool

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.hdfs.HAUtil
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SaveMode, SparkSession}

object GetSourceClusterData {

  final var HIVE_META_SERVER_ADDR: String = ""

  def main(args: Array[String]): Unit = {

    val HDFS_ADDR: String = getActiveNode

    var hiveTable: String = ""
    var batchStartDate: String = ""
    var batchEndDate: String = ""

    if(args.length < 3) {
      sys.error("")
    } else {
      hiveTable = args(0)
      batchStartDate = args(1)
      batchEndDate = args(2)
    }

    val spark: SparkSession = SparkSession.builder()
      .appName("")
      .config("hive.metastore.uris", HIVE_META_SERVER_ADDR)
      .config("", "")
      .enableHiveSupport()
      .getOrCreate()

    changeHDFSConf(spark, "", "", "", "", "")


    val selectSql =
      s"""
         |SELECT *
         |FROM ${hiveTable}
         |WHERE dt BETWEEN ${batchStartDate} ADN ${batchEndDate}
         |""".stripMargin

    spark.sql(selectSql)
      .write
      .partitionBy("dt")
      .mode(SaveMode.Append)
      .format("parquet")
      .save(s"hdfs://$HDFS_ADDR/tmp/$hiveTable")
  }

  /**
   * 连接其他集群的Hive，修改默认HDFS参数
   *
   * @param spark SparkSession对象
   * @param nameSpace 计群命名空间
   * @param nameNode1 NameNode1 ID
   * @param nn1Addr NameNode1对应 IP:port
   * @param nameNode2 NameNode2 ID
   * @param nn2Addr NameNode2对应 IP:port
   */
  def changeHDFSConf(spark: SparkSession, nameSpace: String, nameNode1: String, nn1Addr: String, nameNode2: String, nn2Addr: String): Unit = {
    val sc: SparkContext = spark.sparkContext

    sc.hadoopConfiguration.set(s"fs.defaultFS", s"hdfs://$nameSpace")
    sc.hadoopConfiguration.set(s"dfs.nameservices", nameSpace)
    sc.hadoopConfiguration.set(s"dfs.ha.namenodes.$nameSpace", s"$nameNode1,$nameNode2")
    sc.hadoopConfiguration.set(s"dfs.namenode.rpc-address.$nameSpace.$nameNode1", nn1Addr)
    sc.hadoopConfiguration.set(s"dfs.namenode.rpc-address.$nameSpace.$nameNode2", nn2Addr)
    sc.hadoopConfiguration.set(s"dfs.client.failover.proxy.provider.$nameSpace", "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider")
  }

  def getActiveNode: String = {
    val hadoopConf: Configuration = new Configuration()
    val fs: FileSystem = FileSystem.get(hadoopConf)
    HAUtil.getAddressOfActive(fs).toString.split("/")(1)
  }

}
