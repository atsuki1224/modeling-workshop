package lib.model.level3

import ixias.model._
import java.time.LocalDateTime

import Shop._
case class Shop(
  id:           Option[Shop.Id],
  venuId:       Venu.Id,
  name:         String,
  phone:        String,
  place:        String,
  menu:         Seq[String],
  imageUrl:     String,
  introduction: String,
  updatedAt:    LocalDateTime = NOW,
  createdAt:    LocalDateTime = NOW
) extends EntityModel[Id]

object Shop {

  val Id          = the[Identity[Id]]
  type Id         = Long @@ Shop
  type WithNoId   = Entity.WithNoId[Id, Shop]
  type EmbeddedId = Entity.EmbeddedId[Id, Shop]

  def apply(
    name:         String,
    venuId:       Venu.Id,
    phone:        String,
    place:        String,
    menu:         Seq[String],
    imageUrl:     String,
    introduction: String
  ): WithNoId = {
    new Entity.WithNoId(
      new Shop(
        id           = None,
        venuId       = venuId,
        name         = name,
        phone        = phone,
        place        = place,
        menu         = menu,
        imageUrl     = imageUrl,
        introduction = introduction
      )
    )
  }
}
