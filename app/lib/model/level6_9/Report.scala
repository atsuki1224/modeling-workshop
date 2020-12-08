package lib.model.level6_9

import ixias.model._
import java.time.LocalDateTime

import Report._
case class Report(
  id:                  Option[Report.Id],
  purchasesId:         Purchasing.Id,
  purchases:           Int,
  stocktakeId:         Stacktake.Id,
  inventories:         Int,
  lastYearStocktakeId: Stacktake.Id,
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
    purchasesId:         Purchasing.Id,
    purchases:           Int,
    stocktakeId:         Stacktake.Id,
    inventories:         Int,
    lastYearStocktakeId: Stacktake.Id,
    lastYearInventories: Int,
    cost:                Int
  ): WithNoId = {
    new Entity.WithNoId(
      new Report(
        id                  = None,
        purchasesId         = purchasesId,
        purchases           = purchases,
        stocktakeId         = stocktakeId,
        inventories         = inventories,
        lastYearStocktakeId = lastYearStocktakeId,
        lastYearInventories = lastYearInventories,
        cost                = cost
      )
    )
  }
}
