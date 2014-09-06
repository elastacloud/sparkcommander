package org.apache.spark.commander

import java.util.logging.Logger

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import org.apache.spark.{SparkEnv, SparkContext, SparkConf}

import org.scalatra._
import javax.servlet.ServletContext

// set SBT_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 && sbt
class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new SparkCommanderController, "/*")
  }
}
