package lib.model.level4

import ixias.model._
import java.time.LocalDateTime

//設備
import Equipment._
case class Equipment(
  id:        Option[Equipment.Id],
  name:      String,
  updatedAt: LocalDateTime = NOW,
  createdAt: LocalDateTime = NOW
) extends EntityModel[Id]

object Equipment {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Equipment
  type WithNoId   = Entity.WithNoId [Id, Equipment]
  type EmbeddedId = Entity.EmbeddedId[Id, Equipment]

  def apply(
    name: String
  ): WithNoId = {
    new Entity.WithNoId(
      new Equipment(
        id   = None,
        name = name
      )
    )
  }
}
