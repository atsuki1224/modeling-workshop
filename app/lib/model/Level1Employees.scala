package lib.model

import ixias.model._
import ixias.util.EnumStatus

import java.time.LocalDateTime

import Employees._
case class Employees(
  id:        Option[Employees.Id],
  state:     Status,
  email:     String,
  teamId:    Option[Team.Id],
  updatedAt: LocalDateTime         = NOW,
  createdAt: LocalDateTime         = NOW
) extends EntityModel[Id]

object Employees {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Employees
  type WithNoId   = Entity.WithNoId [Id, Employees]
  type EmbeddedId = Entity.EmbeddedId[Id, Employees]

  sealed abstract class Status(val code: Short, val name: String) extends EnumStatus
  object Status extends EnumStatus.Of[Status] {
    case object IS_ACTIVE   extends Status(code = 0, name = "稼働中")
    case object IS_INACTIVE extends Status(code = 1, name = "休憩中")
  }
 
  def apply(state: Status, email: String, teamId: Option[Team.Id]): WithNoId = {
    new Entity.WithNoId(
      new Employees(
        id     = None,
        state  = state,
        email  = email,
        teamId = teamId
      )
    )
  }
}
