package controllers
import play.api.mvc.{Action, Controller}
import models.Professeur
object Professeurs
  extends Controller {
  def list = Action { implicit request =>
    val professeurs = Professeur.findAll
    Ok(views.html.professeurs.list(professeurs))
  }
}