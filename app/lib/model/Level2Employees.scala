package lib.model

import ixias.model._
import ixias.util.EnumStatus

import java.time.LocalDateTime

import Employee._
case class Employee(
  id:        Option[Employee.Id],
  name:      String,
  state:     Status,
  email:     String,
  teamId:    Option[Team.Id],
  updatedAt: LocalDateTime         = NOW,
  createdAt: LocalDateTime         = NOW
) extends EntityModel[Id]

object Employee {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ Employee
  type WithNoId   = Entity.WithNoId [Id, Employee]
  type EmbeddedId = Entity.EmbeddedId[Id, Employee]

  sealed abstract class Status(val code: Short, val name: String) extends EnumStatus
  object Status extends EnumStatus.Of[Status] {
    case object IS_ACTIVE   extends Status(code = 0, name = "稼働中")
    case object IS_INACTIVE extends Status(code = 1, name = "休憩中")
  }
 
  def apply(name: String, state: Status, email: String, teamId: Option[Team.Id]): WithNoId = {
    new Entity.WithNoId(
      new Employee(
        id     = None,
        name   = name,
        state  = state,
        email  = email,
        teamId = teamId
      )
    )
  }
}
