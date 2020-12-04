package lib.model.level4

import ixias.model._
import ixias.util.EnumStatus
import java.time.LocalDateTime

//会議室
import Space._
case class Space(
  id:        Option[Space.Id],
  name:      String,
  floor:     Int,
  size:      Size,
  status:    Status,
  updatedAt: LocalDateTime     = NOW,
  createdAt: LocalDateTime     = NOW
) extends EntityModel[Id]

object Space {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Space
  type WithNoId   = Entity.WithNoId [Id, Space]
  type EmbeddedId = Entity.EmbeddedId[Id, Space]

  //会議室の広さ
  sealed abstract class Size(val code: Short, val value: String) extends EnumStatus
  object Size extends EnumStatus.Of[Status] {
    case object Small  extends Status(code = 0, value = "小会議室")
    case object Medium extends Status(code = 1, value = "会議室")
    case object Large  extends Status(code = 2, value = "大会議室")
  }

  //会議室のステータス
  sealed abstract class Status(val code: Short, val value: String) extends EnumStatus
  object Status extends EnumStatus.Of[Status] {
    case object IS_STOP     extends Status(code = 0, value = "使用禁止")
    case object IS_ACTIVE   extends Status(code = 1, value = "使用中")
    case object IS_INACTIVE extends Status(code = 2, value = "未使用")
  }

  def apply(
    name:   String,
    floor:  Int,
    size:   Size,
    status: Status,
  ): WithNoId = {
    new Entity.WithNoId(
      new Space(
        id     = None,
        name   = name,
        floor  = floor,
        size   = size,
        status = status
      )
    )
  }
}
