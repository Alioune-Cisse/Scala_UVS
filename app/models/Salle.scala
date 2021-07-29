package models

import play.api.db._
import anorm._
import play.api.db.DB
import play.api.Play.current

case class Salle(
                       lib: String,
                       num: String
                     )

object Salle {

  var salles = Set(Salle("",""))

  val conn = DB.getConnection()

  try {
    val stmt = conn.createStatement
    val rs = stmt.executeQuery(
      """SELECT *
        |from salle""".stripMargin)

    while (rs.next()) {

      salles += Salle(
        rs.getString("Libelle"),
        rs.getString("num")
      )
    }
    salles -= Salle("","")
  } finally {
    conn.close()
  }
  //var tab  = Array(idCours, idProf, numSall)
  //Ok(idCours)
  def findAll = salles.toList
}

