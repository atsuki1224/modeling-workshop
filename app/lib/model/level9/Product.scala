package lib.model.level9

import ixias.model._
import java.time.LocalDateTime

import Product._
case class Product(
  id:         Option[Product.Id],
  name:       String,
  price:      Int,
  categoryId: Category.Id,
  updatedAt:  LocalDateTime = NOW,
  createdAt:  LocalDateTime = NOW
) extends EntityModel[Id]

object Product {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Product
  type WithNoId   = Entity.WithNoId[Id, Product]
  type EmbeddedId = Entity.EmbeddedId[Id, Product]

  def apply(
    name:       String,
    price:      Int,
    categoryId: Category.Id
  ): WithNoId = {
    new Entity.WithNoId(
      new Product(
        id         = None,
        name       = name,
        price      = price,
        categoryId = categoryId
      )
    )
  }
}
