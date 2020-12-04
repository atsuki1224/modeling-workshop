package lib.model.level4

import ixias.model._
import java.time.LocalDateTime

//予約情報
import Reservation._
case class Reservation(
  id:                  Option[Reservation.Id],
  spaceId:             Space.Id,
  reservationDateTime: LocalDateTime = NOW, //予約した日時
  startDateTime:       LocalDateTime,       //利用開始日時
  endDateTime:         LocalDateTime,       //利用終了日時
  updatedAt:           LocalDateTime = NOW,
  createdAt:           LocalDateTime = NOW
) extends EntityModel[Id]

object Reservation {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Reservation
  type WithNoId   = Entity.WithNoId[Id, Reservation]
  type EmbeddedId = Entity.EmbeddedId[Id, Reservation]

  def apply(
    spaceId:       Space.Id,
    startDateTime: LocalDateTime,
    endDateTime:   LocalDateTime
  ): WithNoId = {
    new Entity.WithNoId(
      new Reservation(
        id            = None,
        spaceId       = spaceId,
        startDateTime = startDateTime,
        endDateTime   = endDateTime
      )
    )
  }
}
