package controllers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.{contain, convertToAnyMustWrapper}
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import play.api.db._
import play.api.test.Helpers._
import play.api.test._

class ShoppingListRequestSpec extends AnyFlatSpec  {



  "GET" should "give assortment" in {

    val controller = new ShoppingListController(stubControllerComponents())
    val result  = controller.opvraag().apply(FakeRequest(GET, "/"))

    status(result) mustBe OK
    contentAsString(result).contains("Broodje") shouldEqual true
  }


}

