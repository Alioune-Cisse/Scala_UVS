package models

import play.api.db._
import anorm._
import play.api.db.DB
import play.api.Play.current

case class Moyenne_Fil(lib: String, moyenne: String)

object Moyenne_Fil {

  var mc = Set(Moyenne_Fil("",""))

  val conn = DB.getConnection()

  try {
    val stmt = conn.createStatement
    val rs = stmt.executeQuery(

      """SELECT Libelle, CAST(ROUND(AVG(((devoir1+devoir2)/2 +exam)/2),2) AS DEC(10,2)) moyenne
        |
        |FROM notesetudiants p INNER JOIN matiere c ON c.codeMat = p.codeMat
        |
        |GROUP BY Libelle ORDER BY Libelle""".stripMargin
    )

    while (rs.next()) {

      mc += Moyenne_Fil(
        rs.getString("Libelle"),
        rs.getString("moyenne")
      )
    }
    mc -= Moyenne_Fil("","")
  } finally {
    conn.close()
  }
  //var tab  = Array(idCours, idProf, numSall)
  //Ok(idCours)
  def findAll = mc.toList
}

