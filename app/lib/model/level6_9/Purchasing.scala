package lib.model.level6_9

import ixias.model._
import java.time.{ LocalDate, LocalDateTime }

import Purchasing._
case class Purchasing(
  id:             Option[Purchasing.Id],
  totalAmount:    Int,
  purchasingDate: LocalDate,
  updatedAt:      LocalDateTime = NOW,
  createdAt:      LocalDateTime = NOW
) extends EntityModel[Id]

object Purchasing {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Purchasing
  type WithNoId   = Entity.WithNoId[Id, Purchasing]
  type EmbeddedId = Entity.EmbeddedId[Id, Purchasing]

  def apply(
    totalAmount:    Int,
    purchasingDate: LocalDate
  ): WithNoId = {
    new Entity.WithNoId(
      new Purchasing(
        id             = None,
        purchasingDate = purchasingDate,
        totalAmount    = totalAmount
      )
    )
  }
}