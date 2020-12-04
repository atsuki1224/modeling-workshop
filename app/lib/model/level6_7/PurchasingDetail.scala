package lib.model.level6_7

import ixias.model._
import java.time.LocalDateTime

import PurchasingDetail._
case class PurchasingDetail(
  id:           Option[PurchasingDetail.Id],
  purchasingId: Purchasing.Id,
  productId:    Product.Id,
  stock:        Int,
  price:        Int,
  updatedAt:    LocalDateTime = NOW,
  createdAt:    LocalDateTime = NOW
) extends EntityModel[Id]

object PurchasingDetail {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ PurchasingDetail
  type WithNoId   = Entity.WithNoId[Id, PurchasingDetail]
  type EmbeddedId = Entity.EmbeddedId[Id, PurchasingDetail]

  def apply(
    purchasingId: Purchasing.Id,
    productId:    Product.Id,
    stock:        Int,
    price:        Int
  ): WithNoId = {
    new Entity.WithNoId(
      new PurchasingDetail(
        id           = None,
        purchasingId = purchasingId,
        productId    = productId,
        stock        = stock,
        price        = price
      )
    )
  }
}
