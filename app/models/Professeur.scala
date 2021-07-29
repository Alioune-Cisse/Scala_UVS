package models

import play.api.db._
import anorm._
import play.api.db.DB
import play.api.Play.current

case class Professeur(
                     idProf: String,
                     lib: String,
                     nomProf: String,
                     prenomProf: String,
                     grade: String
                     )

object Professeur {

  var professeurs = Set(Professeur("","","","",""))

  val conn = DB.getConnection()

  try {
    val stmt = conn.createStatement
    val rs = stmt.executeQuery(
      """SELECT *
        |from professeur,matiere
        |where TRIM(professeur.codeMat) = TRIM(matiere.codeMat)
        |group By professeur.idProf""".stripMargin)

    while (rs.next()) {

      professeurs += Professeur(
        rs.getString("idProf"),
        rs.getString("Libelle"),
        rs.getString("nomProf"),
        rs.getString("prenomProf"),
        rs.getString("grade")
      )
    }
    professeurs -= Professeur("","","","","")
  } finally {
    conn.close()
  }
  //var tab  = Array(idCours, idProf, numSall)
  //Ok(idCours)
  def findAll = professeurs.toList
}

