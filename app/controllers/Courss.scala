package controllers
import play.api.mvc.{Action, Controller}
import models.Cours
object Courss extends Controller {
  def list = Action { implicit request =>
    val cours = Cours.findAll
    Ok(views.html.cours.list(cours))
  }
}