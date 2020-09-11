package cn.michael.dev.spark.tool

import org.apache.spark.sql.SparkSession

object PutTargetClusterData {

  final var HIVE_META_SERVER_ADDR: String = ""

  def main(args: Array[String]): Unit = {

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

    spark.sql(
      """
        |
        |""".stripMargin)
  }

}
