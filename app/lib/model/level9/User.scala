package lib.model.level9

import ixias.model._
import java.time.LocalDateTime

import User._
case class User(
  id:        Option[User.Id],
  name:      String,
  updatedAt: LocalDateTime = NOW,
  createdAt: LocalDateTime = NOW
) extends EntityModel[Id]

object User {

  val  Id         = the[Identity[Id]]
  type Id         = Long @@ User
  type WithNoId   = Entity.WithNoId[Id, User]
  type EmbeddedId = Entity.EmbeddedId[Id, User]

  def apply(
    name: String
  ): WithNoId = {
    new Entity.WithNoId(
      new User(
        id   = None,
        name = name
      )
    )
  }
}
