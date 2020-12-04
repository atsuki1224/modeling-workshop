package lib.model.level6

import ixias.model._
import java.time.LocalDateTime

import Purchasing._
case class Purchasing(
  id:             Option[Purchasing.Id],
  totalAmount:    Int,
  purchasingDate: LocalDateTime = NOW,
  updatedAt:      LocalDateTime = NOW,
  createdAt:      LocalDateTime = NOW
) extends EntityModel[Id]

object Purchasing {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Purchasing
  type WithNoId   = Entity.WithNoId[Id, Purchasing]
  type EmbeddedId = Entity.EmbeddedId[Id, Purchasing]

  def apply(
    totalAmount:    Int
  ): WithNoId = {
    new Entity.WithNoId(
      new Purchasing(
        id          = None,
        totalAmount = totalAmount
      )
    )
  }
}
