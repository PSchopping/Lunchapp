package controllers
import javax.inject.Inject
import play.api.db._
import play.api.libs.json.Json
import play.api.mvc._

class ScalaControllerInject @Inject()(db: Database, val controllerComponents: ControllerComponents)
  extends BaseController {

  def index = Action {
    var outString = "Assortiments is "
    val conn      = db.getConnection()


    try {
      val stmt = conn.createStatement
      val rs   = stmt.executeQuery("SELECT*FROM Lunch")

      while (rs.next()) {
        outString += rs.getString("item")
        outString += (" ")
      }
    } finally {
      conn.close()
    }
    Ok(Json.toJson(outString))
  }

}