package lib.model.level6_7

import ixias.model._
import java.time.LocalDateTime

import Stacktake._
case class Stacktake(
  id:                 Option[Stacktake.Id],
  totalStockQuantity: Int, //在庫総数
  totalStockPrice:    Int, //在庫合計金額
  updatedAt:          LocalDateTime    = NOW,
  createdAt:          LocalDateTime    = NOW
) extends EntityModel[Id]

object Stacktake {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Stacktake
  type WithNoId   = Entity.WithNoId[Id, Stacktake]
  type EmbeddedId = Entity.EmbeddedId[Id, Stacktake]

  def apply(
  totalStockQuantity: Int,
  totalStockPrice:    Int
  ): WithNoId = {
    new Entity.WithNoId(
      new Stacktake(
        id   = None,
        totalStockQuantity = totalStockQuantity,
        totalStockPrice    = totalStockPrice
      )
    )
  }
}

