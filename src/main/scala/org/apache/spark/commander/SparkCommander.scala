package org.apache.spark.commander

import org.apache.spark.{SparkEnv, SparkContext, SparkConf}

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, ArrayBuffer}

// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra

/**
 * Created by Richard on 9/5/2014.
 */
object SparkCommander {

  lazy val context = {
    val env = SparkEnv.get

    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("Spark Commander")

     new SparkContext(conf)
  }

  val buffer = new ListBuffer[SparkWorker]()

  def getWorkerStatus : List[SparkWorker] = {

    buffer.clear

    val status = context.getExecutorMemoryStatus
    status.map( mapValue => {
      buffer += SparkWorker(mapValue._1, (mapValue._2._1 / (10 ^ 6)).toDouble)
    })
    buffer.result

  }

}
