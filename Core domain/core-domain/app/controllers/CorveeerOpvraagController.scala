package controllers

import javax.inject.Inject
import scala.concurrent.Future
import scala.concurrent.duration._
import play.api.mvc._
import play.api.libs.ws._
import play.api.http.HttpEntity
import akka.actor.ActorSystem
import akka.stream.scaladsl._
import akka.util.ByteString

import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global



class CorveeerOpvraagController @Inject()(ws: WSClient, val controllerComponents: ControllerComponents)
  extends BaseController {

  /*
  val request: WSRequest = ws.url("http://localhost:7000/corveeer")
  val futureResponse: Future[WSResponse] = request.get()
*/
  def opvraag = Action.async {
    ws.url("http://localhost:7000/corveeer").get().map { response =>
      Ok(response.body)
    }
  }
}