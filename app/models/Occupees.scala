package models

import play.api.db._
import anorm._
import play.api.db.DB
import play.api.Play.current

case class Occupees(
                  salles: String,
                  num: String,
                  jours : String,
                  heures : String,
                  profs : String,
                  mat : String
                )

object Occupees {

  var salles = Set(Occupees("","","","","",""))

  val conn = DB.getConnection()

  try {
    val stmt = conn.createStatement
    val rs = stmt.executeQuery(
      """SELECT heures, jours, mat, numSall, Libelle, profs
        |from salle, occupees
        |WHERE occupees.numSall=salle.num
        |ORDER BY numSall, jours""".stripMargin)

    while (rs.next()) {

      salles += Occupees(
        rs.getString("Libelle"),
        rs.getString("numSall"),
        rs.getString("jours"),
        rs.getString("heures"),
        rs.getString("profs"),
        rs.getString("mat")
      )
    }
    salles -= Occupees("","","","","","")
  } finally {
    conn.close()
  }
  //var tab  = Array(idCours, idProf, numSall)
  //Ok(idCours)
  def findAll = salles.toList
}