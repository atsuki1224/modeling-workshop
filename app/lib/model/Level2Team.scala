package lib.model

import ixias.model._

import java.time.LocalDateTime

import Team._
case class Team(
  id:           Option[Team.Id],
  name:         String,
  introduction: String,
  updatedAt:    LocalDateTime    = NOW,
  createdAt:    LocalDateTime    = NOW
) extends EntityModel[Id]

object Team {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Team
  type WithNoId   = Entity.WithNoId [Id, Team]
  type EmbeddedId = Entity.EmbeddedId[Id, Team]

  def apply(name: String, introduction: String): WithNoId = {
    new Entity.WithNoId(
      new Team(
        id           = None,
        name         = name,
        introduction = introduction
      )
    )
  }
}

