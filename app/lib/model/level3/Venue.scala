package lib.model.level3

import ixias.model._
import java.time.LocalDateTime

import Venu._
case class Venu(
  id:        Option[Venu.Id],
  name:      String,
  updatedAt: LocalDateTime = NOW,
  createdAt: LocalDateTime = NOW
) extends EntityModel[Id]

object Venu {

  val Id          = the[Identity[Id]]
  type Id         = Long @@ Venu
  type WithNoId   = Entity.WithNoId[Id, Venu]
  type EmbeddedId = Entity.EmbeddedId[Id, Venu]

  def apply(
    name:         String
  ): WithNoId = {
    new Entity.WithNoId(
      new Venu(
        id   = None,
        name = name
      )
    )
  }
}

