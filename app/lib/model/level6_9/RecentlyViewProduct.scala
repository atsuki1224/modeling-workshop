package lib.model.level6_9

import ixias.model._
import java.time.LocalDateTime

import RecentlyViewProduct._
case class RecentlyViewProduct(
  id:           Option[RecentlyViewProduct.Id],
  userId:       User.Id,
  productId:    Product.Id,
  viewDateTime: LocalDateTime = NOW,
  updatedAt:    LocalDateTime = NOW,
  createdAt:    LocalDateTime = NOW
) extends EntityModel[Id]

object RecentlyViewProduct {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ RecentlyViewProduct
  type WithNoId   = Entity.WithNoId[Id, RecentlyViewProduct]
  type EmbeddedId = Entity.EmbeddedId[Id, RecentlyViewProduct]

  def apply(
    userId:    User.Id,
    productId: Product.Id
  ): WithNoId = {
    new Entity.WithNoId(
      new RecentlyViewProduct(
        id        = None,
        userId    = userId,
        productId = productId
      )
    )
  }
}
