package lib.model.level8

import ixias.model._
import java.time.LocalDateTime

import Report._
case class Report(
  id:                  Option[Report.Id],
  purchases:           Int,
  inventories:         Int,
  lastYearInventories: Int,
  cost:                Int,
  updatedAt:           LocalDateTime = NOW,
  createdAt:           LocalDateTime = NOW
) extends EntityModel[Id]

object Report {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Report
  type WithNoId   = Entity.WithNoId [Id, Report]
  type EmbeddedId = Entity.EmbeddedId[Id, Report]

  def apply(
    purchases:           Int,
    inventories:         Int,
    lastYearInventories: Int,
    cost:                Int
  ): WithNoId = {
    new Entity.WithNoId(
      new Report(
        id                  = None,
        purchases           = purchases,
        inventories         = inventories,
        lastYearInventories = lastYearInventories,
        cost                = cost
      )
    )
  }
}
