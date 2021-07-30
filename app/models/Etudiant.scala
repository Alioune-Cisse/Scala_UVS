package models

import play.api.db._
import anorm._
import play.api.db.DB
import play.api.Play.current

case class Etudiant(
                     idEtu: String,
                     niveau: String,
                     nomEtu: String,
                     prenomEtu: String,
                     code: String,
                     devoir1:Array[String],
                     devoir2:Array[String],
                     exam:Array[String],
                     coef:Array[String],
                     Libelle:Array[String])

object Etudiant {
  val arr:Array[String] = Array("")

  var etudiants = Set(Etudiant("","","","","",arr,arr,arr,arr,arr))

  val conn = DB.getConnection()

  try {
    val stmt = conn.createStatement
    val rs = stmt.executeQuery(
      """SELECT etudiant.idEtu, nomEtu, prenomEtu, niveau,
        | GROUP_CONCAT(matiere.codeMat, ',') as codeMat,
        |  GROUP_CONCAT(devoir1, '') as devoir1,
        |   GROUP_CONCAT(devoir2, '') as devoir2,
        |    GROUP_CONCAT(exam, '') as exam,
        |     GROUP_CONCAT(Coef, '') as Coef,
        |      GROUP_CONCAT(Libelle, ',') as Libelle
        |from etudiant,notesetudiants,matiere
        |where TRIM(notesetudiants.codeMat) = TRIM(matiere.codeMat) and TRIM(notesetudiants.idEtu) = TRIM(etudiant.idEtu)
        |group By etudiant.idEtu order By nomEtu""".stripMargin)

    while (rs.next()) {
      //Libellé
      val lib : Array[String] = rs.getString("Libelle").split(",,").map (_.trim)
      // Devoir 1
      val dev1: Array[String] = rs.getString("devoir1").split(",").map (_.trim)
      //Devoir 2
      val dev2 : Array[String] = rs.getString("devoir2").split(",").map (_.trim)
      // Examen
      val exam: Array[String] = rs.getString("exam").split(",").map (_.trim)
      //Coef
      val coef : Array[String] = rs.getString("Coef").split(",").map (_.trim)

      etudiants += Etudiant(
        rs.getString("idEtu"),
        rs.getString("niveau"),
        rs.getString("nomEtu"),
        rs.getString("prenomEtu"),
        rs.getString("codeMat"),
        dev1,
        dev2,
        exam,
        coef,
        lib
      )
    }
    etudiants -= Etudiant("","","","","",arr,arr,arr,arr,arr)
  } finally {
    conn.close()
  }
  //var tab  = Array(idCours, idProf, numSall)
  //Ok(idCours)
  def findAll = etudiants.toList
}

