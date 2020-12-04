package lib.model.level5

import ixias.model._
import java.time.LocalDateTime

//公園に紐付く遊具
import ParkEquipment._
case class ParkEquipment(
  id:          Option[ParkEquipment.Id],
  parkId:      Park.Id,
  equipmentId: Equipment.Id,
  location:    String,
  updatedAt:   LocalDateTime = NOW,
  createdAt:   LocalDateTime = NOW
) extends EntityModel[Id]

object ParkEquipment {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ ParkEquipment
  type WithNoId   = Entity.WithNoId[Id, ParkEquipment]
  type EmbeddedId = Entity.EmbeddedId[Id, ParkEquipment]

  def apply(
    name:        String,
    parkId:      Park.Id,
    equipmentId: Equipment.Id,
    location:    String
  ): WithNoId = {
    new Entity.WithNoId(
      new ParkEquipment(
        id          = None,
        parkId      = parkId,
        equipmentId = equipmentId,
        location    = location
      )
    )
  }
}
