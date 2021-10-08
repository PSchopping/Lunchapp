package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import org.scalatest.flatspec.AnyFlatSpec
import play.api.db._

class AssortimentOpvraagSpec extends AnyFlatSpec  {



  "GET" should "give assortment" in {
    val database = Databases(
      driver = "com.mysql.jdbc.Driver",
      url = "jdbc:mysql://localhost/assort?autoReconnect=true&useSSL=false",
      config = Map(
        "username" -> "root",
        "password" -> "AwE2020!?"
      )
    )

    val controller = new AssortimentOpvraagController(database,stubControllerComponents())
    val result  = controller.opvraag().apply(FakeRequest(GET, "/"))
    assert(contentAsString(result)=="\"Assortiments is Broodje Salade \"")
  }


}

