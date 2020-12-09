package lib.model.level6_9

import ixias.model._
import java.time.LocalDateTime

import StocktakeDetail._
case class StocktakeDetail(
  id:                Option[StocktakeDetail.Id],
  stocktakeId:       Stacktake.Id,
  productId:         Product.Id,
  price:             Int,
  stock:             Int,
  productTotalPrice: Int,
  updatedAt:         LocalDateTime = NOW,
  createdAt:         LocalDateTime = NOW
) extends EntityModel[Id]

object StocktakeDetail {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ StocktakeDetail
  type WithNoId   = Entity.WithNoId[Id, StocktakeDetail]
  type EmbeddedId = Entity.EmbeddedId[Id, StocktakeDetail]

  def apply(
    purchasingId:      Purchasing.Id,
    stocktakeId:       Stacktake.Id,
    productId:         Product.Id,
    price:             Int,
    stock:             Int,
    productTotalPrice: Int,
  ): WithNoId = {
    new Entity.WithNoId(
      new StocktakeDetail(
        id   = None,
        stocktakeId       = stocktakeId,
        productId         = productId,
        price             = price,
        stock             = stock,
        productTotalPrice = productTotalPrice
      )
    )
  }
}
