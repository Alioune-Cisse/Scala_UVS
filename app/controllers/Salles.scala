package controllers
import play.api.mvc.{Action, Controller}
import models.Salle
object Salles
  extends Controller {
  def list = Action { implicit request =>
    val salles = Salle.findAll
    Ok(views.html.salles.list(salles))
  }
}