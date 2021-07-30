package controllers
import play.api.mvc.{Action, Controller}
import models.Occupees
object Occupeess
  extends Controller {
  def list = Action { implicit request =>
    val salles = Occupees.findAll
    Ok(views.html.salles.occupees(salles))
  }
}