package cn.michael.dev.flink.datastream

import org.apache.flink.streaming.api.datastream.DataStreamSource
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment

/**
 * Created by hufenggang on 2020/6/18.
 */
object ExampleMap01 {

  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream: DataStreamSource[(String, Int)] = env.fromElements(("a", 3), ("d", 4), ("c", 2), ("c", 5), ("a", 5))

  }

}
