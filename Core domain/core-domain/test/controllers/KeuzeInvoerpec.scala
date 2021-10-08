package controllers

import org.scalatest.flatspec.AnyFlatSpec
import play.api.db._
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test._

class KeuzeInvoerpec extends AnyFlatSpec  {



  "POST" should "store choice" in {


    val controller = new LunchChoiceController(stubControllerComponents())
    val result  = controller.store().apply(FakeRequest(POST, "/").withJsonBody(Json.parse("""{ "EmployeeID": 14, "Choice" : "Broodje" }""")))
    assert(contentAsString(result)=="14 chose Broodje")
  }


}

