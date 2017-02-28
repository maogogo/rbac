import sbt._
import Keys._
import Process._

import com.typesafe.sbt.packager.archetypes._
import com.typesafe.sbt.SbtScalariform._

import BuildSettings._
import Dependencies._

lazy val common = Project("rbac-common", file("common"))//(project in file("common"))
  .dependsOn(thrift)
  .settings(basicSettings: _*)
  .settings(libraryDependencies ++= commonDependency)
  .settings(libraryDependencies ++= mysqlDependency)
  .settings(libraryDependencies ++= serverDependency)
  .settings(libraryDependencies ++= redisDependency)
  .settings(libraryDependencies ++= kafkaDependency)


// lazy val client = Project("rbac-client", file("client"))//(project in file("rest"))
//   .dependsOn(common)
//   .settings(basicSettings: _*)
//   .settings(libraryDependencies ++= finchDependency)
//   .enablePlugins(JavaServerAppPackaging)

lazy val rest = Project("rbac-rest", file("rest"))//(project in file("rest"))
  .dependsOn(common)
  .settings(basicSettings: _*)
  .settings(mapSettings: _*)
  .settings(libraryDependencies ++= finchDependency)
  .enablePlugins(JavaServerAppPackaging)

lazy val rpc = Project("rbac-rpc", file("rpc"))//(project in file("rpc"))
  .dependsOn(common)
  .settings(basicSettings: _*)
  .enablePlugins(JavaServerAppPackaging)

lazy val thrift = Project("rbac-thrift", file("thrift"))//(project in file("thrift"))
  .settings(basicSettings: _*)
  .settings(thriftSettings: _*)
  .settings(libraryDependencies ++= thriftDependency)

lazy val root = Project("rbac", file(".")) //(project in file("."))
    .aggregate(thrift, rest, rpc, common)
    .settings(defaultScalariformSettings: _*)
