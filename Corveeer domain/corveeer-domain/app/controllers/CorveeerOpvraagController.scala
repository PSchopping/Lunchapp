package controllers

import model.DTO.Corveeer
import play.api.db._
import play.api.libs.json.Json
import play.api.mvc._

import javax.inject.Inject
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class CorveeerOpvraagController @Inject()( val controllerComponents: ControllerComponents)
  extends BaseController {
  val db = Databases(
    driver = "org.postgresql.Driver",
    url = "jdbc:postgresql://localhost/employees?autoReconnect=true&useSSL=false",
    config = Map(
      "username" -> "postgres",
      "password" -> "root"
    )
  )

  implicit val corveeerJson = Json.format[Corveeer]

  def opvraag = Action {

    val conn      = db.getConnection()

    val Choices =new mutable.ListBuffer[Corveeer]()

    try {
      val stmt = conn.createStatement
      val rs   = stmt.executeQuery("SELECT*FROM employees")

      while (rs.next()) {
        Choices += Corveeer(rs.getString("EmployeeID").toInt,rs.getString("Name"))
      }
    } finally {
      conn.close()
    }
    val random = scala.util.Random
    val length = Choices.length
    val r = random.nextInt(length)

    Ok(Json.toJson(Choices(r)))
  }

}