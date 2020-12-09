package lib.model.level6_9

import ixias.model._
import java.time.LocalDateTime

import Category._
case class Category(
  id:        Option[Category.Id],
  name:      String,
  updatedAt: LocalDateTime = NOW,
  createdAt: LocalDateTime = NOW
) extends EntityModel[Id]

object Category {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Category
  type WithNoId   = Entity.WithNoId[Id, Category]
  type EmbeddedId = Entity.EmbeddedId[Id, Category]

  def apply(
    name: String
  ): WithNoId = {
    new Entity.WithNoId(
      new Category(
        id   = None,
        name = name
      )
    )
  }
}
