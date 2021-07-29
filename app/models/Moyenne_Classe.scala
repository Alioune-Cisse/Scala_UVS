package models

import play.api.db._
import anorm._
import play.api.db.DB
import play.api.Play.current

case class Moyenne_Classe(classe: String, moyenne: String)

object Moyenne_Classe {

  var mc = Set(Moyenne_Classe("",""))

  val conn = DB.getConnection()

  try {
    val stmt = conn.createStatement
    val rs = stmt.executeQuery(

      """SELECT niveau, CAST(ROUND(AVG(((devoir1+devoir2)/2 +exam)/2),2) AS DEC(10,2)) moyenne
        |
        |FROM notesetudiants p INNER JOIN etudiant c ON c.idEtu = p.idEtu
        |
        |GROUP BY niveau ORDER BY niveau""".stripMargin
    )

    while (rs.next()) {

      mc += Moyenne_Classe(
        rs.getString("niveau"),
        rs.getString("moyenne")
      )
    }
    mc -= Moyenne_Classe("","")
  } finally {
    conn.close()
  }
  //var tab  = Array(idCours, idProf, numSall)
  //Ok(idCours)
  def findAll = mc.toList
}

