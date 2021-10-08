package controllers

import model.DTO.LunchChoice
import play.api.db.{Database, Databases}
import play.api.libs.json.Json
import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.Inject

class LunchChoiceController @Inject()( val controllerComponents: ControllerComponents)
  extends BaseController {
  implicit val lunchChoiceJson = Json.format[LunchChoice]

  def store = Action { implicit request =>
    val content = request.body
    val jsonObject = content.asJson.get
    val lunchChoiceItem = jsonObject.as[LunchChoice]

    val database = Databases(
      driver = "com.mysql.jdbc.Driver",
      url = "jdbc:mysql://localhost/lunchchoices?autoReconnect=true&useSSL=false",
      config = Map(
        "username" -> "root",
        "password" -> "AwE2020!?"
      )
    )

    database.withTransaction { conn =>
      //val stmt = conn.createStatement

      val insertQuery = "INSERT INTO choices ( EmployeeID, Choice) VALUES( ?,?) "
      /*stmt.executeQuery(insertQuery)*/
      val stmt = conn.prepareStatement(insertQuery)
      stmt.setInt(1,lunchChoiceItem.EmployeeID)
      stmt.setString(2,lunchChoiceItem.Choice)
      val resultSet = stmt.executeUpdate()


      if (resultSet>0) {

        Ok(lunchChoiceItem.EmployeeID + " chose " + lunchChoiceItem.Choice)
      } else {
        throw new Exception("Not stored in database" + resultSet)
      }


    }
  }
}


