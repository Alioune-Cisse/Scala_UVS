package controllers
import play.api.mvc.{Action, Controller}
import models.Etudiant
object Etudiants
  extends Controller {
  def list = Action { implicit request =>
    val etudiants = Etudiant.findAll
    Ok(views.html.etudiants.list(etudiants))
  }
}