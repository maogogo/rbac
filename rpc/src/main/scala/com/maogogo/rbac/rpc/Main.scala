package com.maogogo.rbac.rpc

import com.twitter.inject.server.TwitterServer
import com.twitter.util.Await
import com.maogogo.rbac.rpc.modules.ServicesModule

object Main extends TwitterServer {

  override def postWarmup() {

    //val services = ServicesModule.services(injector)
    //Await.all(services: _*)

    info(s"${logo}\t${adminPort}\t")
    Await.ready(adminHttpServer)
  }

  lazy val logo = """
      ____  ____  ______
     / __ \/ __ \/ ____/
    / /_/ / /_/ / /     
   / _, _/ ____/ /___   
  /_/ |_/_/    \____/     """

}