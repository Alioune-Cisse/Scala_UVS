package controllers
import play.api.mvc.{Action, Controller}
import models.Moyenne_Classe
import  models.Moyenne_Fil
object Moyenne_Fils
  extends Controller {
  def list = Action { implicit request =>
    val mc = Moyenne_Classe.findAll
    val mf = Moyenne_Fil.findAll
    Ok(views.html.visualisation.par_filiere(mf))
  }
}