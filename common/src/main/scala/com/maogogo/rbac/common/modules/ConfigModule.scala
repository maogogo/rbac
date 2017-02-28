package com.maogogo.rbac.common.modules

import com.google.inject._
import com.typesafe.config._
import java.io.File

trait ConfigModule {

  @Provides @Singleton
  def provideConfig: Config = {
    val env = {
      val envProperty = System.getProperty("env")
      val envSystem = if (envProperty == null) System.getenv("env") else envProperty
      if (envSystem == null) "dev" else envSystem
    }

    val path = ConfigFactory.load.getString(env)
    println(s"loading path: ${path} by env: ${env}")
    ConfigFactory parseFile (new File(path)) resolve
  }
}