package controllers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import play.api.test.Helpers._
import play.api.test._

class CorveerrequestSpec extends AnyFlatSpec  {



  "GET" should "give corveeer" in {

    val controller = new CorveeerOpvraagController(stubControllerComponents())
    val result  = controller.opvraag().apply(FakeRequest(GET, "/"))

    status(result) mustBe OK
    contentAsString(result).contains("EmployeeID") shouldEqual true
  }


}

