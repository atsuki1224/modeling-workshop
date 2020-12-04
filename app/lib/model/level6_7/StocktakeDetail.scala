package lib.model.level6_7

import ixias.model._
import java.time.LocalDateTime

import StocktakeDetail._
case class StocktakeDetail(
  id:                Option[StocktakeDetail.Id],
  purchasingId:      Purchasing.Id,
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
    productId:         Product.Id,
    price:             Int,
    stock:             Int,
    productTotalPrice: Int,
  ): WithNoId = {
    new Entity.WithNoId(
      new StocktakeDetail(
        id   = None,
        purchasingId      = purchasingId,
        productId         = productId,
        price             = price,
        stock             = stock,
        productTotalPrice = productTotalPrice
      )
    )
  }
}
