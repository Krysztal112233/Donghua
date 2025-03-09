package dev.krysztal.donghua.animation

import org.bukkit.Location
import org.bukkit.entity.Entity

enum TargetType {
  case ToEntity(entity: Entity)
  case None
}

case class AnimationContext(
    loc: Location,
    target: TargetType
)

object AnimationContext {
  def of(entity: Entity): AnimationContext =
    AnimationContext(entity.getLocation(), TargetType.ToEntity(entity))

  def of(loc: Location): AnimationContext =
    AnimationContext(loc, TargetType.None)
}
