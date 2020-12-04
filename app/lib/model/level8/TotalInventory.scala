package lib.model.level8

import ixias.model._
import java.time.LocalDateTime

import TotalInventory._
case class TotalInventory(
  id:           Option[TotalInventory.Id],
  updatedAt:    LocalDateTime = NOW,
  createdAt:    LocalDateTime = NOW
) extends EntityModel[Id]

object TotalInventory {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ TotalInventory
  type WithNoId   = Entity.WithNoId [Id, TotalInventory]
  type EmbeddedId = Entity.EmbeddedId[Id, TotalInventory]

  def apply(
  ): WithNoId = {
    new Entity.WithNoId(
      new TotalInventory(
        id           = None
      )
    )
  }
}
