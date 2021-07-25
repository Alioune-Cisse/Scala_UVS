package models

import play.api.db._
import anorm._
import play.api.db.DB
import play.api.Play.current

case class Cours(idCours: String, idProf: String, numSall: String, dateCours: String)

object Cours {

  var cours = Set(Cours("","","",""))

    val conn = DB.getConnection()

    try {
      val stmt = conn.createStatement
      val rs = stmt.executeQuery("SELECT * from cours ")
      while (rs.next()) {

        cours += Cours(rs.getString("idCours"), rs.getString("idProf"), rs.getString("numSall"), rs.getString("dateCours"))
      }
    } finally {
      conn.close()
    }
    //var tab  = Array(idCours, idProf, numSall)
    //Ok(idCours)
    def findAll = cours.toList
  }

