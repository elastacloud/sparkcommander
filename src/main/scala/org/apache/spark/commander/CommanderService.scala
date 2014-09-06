package org.apache.spark.commander


import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport

// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._



import scala.collection.mutable.ArrayBuffer

/**
 * Created by azurecoder on 9/5/2014
 * This will deliver details to the user on the current state of the spark cluster
 */

case class SparkWorker(Name: String, Memory: Double)

class SparkCommanderController extends ScalatraServlet with ScalateSupport with JacksonJsonSupport {

  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit val jsonFormats: Formats = DefaultFormats.withDouble

  before() {
    contentType = formats("json")
  }

  get("status")  {
    SparkCommander.getWorkerStatus
  }
}



