package lib.model.level4

import ixias.model._
import java.time.LocalDateTime

//会議室に紐づく設備
import SpaceEquipment._
case class SpaceEquipment(
  id:          Option[SpaceEquipment.Id],
  spaceId:     Space.Id,
  equipmentId: Equipment.Id,
  updatedAt:   LocalDateTime = NOW,
  createdAt:   LocalDateTime = NOW
) extends EntityModel[Id]

object SpaceEquipment {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ SpaceEquipment
  type WithNoId   = Entity.WithNoId[Id, SpaceEquipment]
  type EmbeddedId = Entity.EmbeddedId[Id, SpaceEquipment]

  def apply(
    spaceId: Space.Id,
    equipmentId: Equipment.Id
  ): WithNoId = {
    new Entity.WithNoId(
      new SpaceEquipment(
        id          = None,
        spaceId     = spaceId,
        equipmentId = equipmentId
      )
    )
  }
}
