package lib.model.level5

import ixias.model._
import java.time.LocalDateTime

import Park._
case class Park(
  id:        Option[Park.Id],
  name:      String,
  address:   String,
  updatedAt: LocalDateTime = NOW,
  createdAt: LocalDateTime = NOW
) extends EntityModel[Id]

object Park {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Park
  type WithNoId   = Entity.WithNoId[Id, Park]
  type EmbeddedId = Entity.EmbeddedId[Id, Park]

  def apply(
    name:    String,
    address: String
  ): WithNoId = {
    new Entity.WithNoId(
      new Park(
        id      = None,
        name    = name,
        address = address
      )
    )
  }
}
