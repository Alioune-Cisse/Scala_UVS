package controllers
import play.api.mvc.{Action, Controller}
import models.Moyenne_Classe
import  models.Moyenne_Fil

object TotalBar
  extends Controller {
  def list = Action { implicit request =>

    Ok(views.html.visualisation.totalbar())
  }
}