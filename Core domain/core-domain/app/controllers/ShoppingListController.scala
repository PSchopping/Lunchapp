package controllers

import model.DTO.ShoppingList
import play.api.db._
import play.api.libs.json.Json
import play.api.mvc._

import javax.inject.Inject
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class ShoppingListController @Inject()( val controllerComponents: ControllerComponents)
  extends BaseController {
  val db = Databases(
    driver = "com.mysql.jdbc.Driver",
    url = "jdbc:mysql://localhost/lunchchoices?autoReconnect=true&useSSL=false",
    config = Map(
      "username" -> "root",
      "password" -> "AwE2020!?"
    )
  )

  implicit val shoppingListJson = Json.format[ShoppingList]

  def opvraag = Action {

    val conn      = db.getConnection()

    val Choices =new mutable.ListBuffer[ShoppingList]()

    try {
      val stmt = conn.createStatement
      val rs   = stmt.executeQuery("SELECT*FROM choices")

      while (rs.next()) {
        Choices += ShoppingList(rs.getString("Choice"))
      }
    } finally {
      conn.close()
    }
    Ok(Json.toJson(Choices))
  }

}