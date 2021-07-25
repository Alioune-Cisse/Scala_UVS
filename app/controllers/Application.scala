package controllers

import play.api._
import play.api.mvc._


/*Formulaire et validation
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._*/

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }
  def classes = Action {
    Ok(views.html.classe.classe())
  }

}



