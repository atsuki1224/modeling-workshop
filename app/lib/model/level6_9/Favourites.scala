package lib.model.level6_9

import ixias.model._
import java.time.LocalDateTime

import Favourite._
case class Favourite(
  id:        Option[Favourite.Id],
  userId:    User.Id,
  productId: Product.Id,
  updatedAt: LocalDateTime = NOW,
  createdAt: LocalDateTime = NOW
) extends EntityModel[Id]

object Favourite {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Favourite
  type WithNoId   = Entity.WithNoId[Id, Favourite]
  type EmbeddedId = Entity.EmbeddedId[Id, Favourite]

  def apply(
    userId:    User.Id,
    productId: Product.Id
  ): WithNoId = {
    new Entity.WithNoId(
      new Favourite(
        id        = None,
        userId    = userId,
        productId = productId
      )
    )
  }
}
