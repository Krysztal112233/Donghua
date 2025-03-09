package dev.krysztal.donghua.animation

import lombok.Builder
import org.bukkit.Location

trait AnimationPlayer {
  def play(): Unit
  def remove(): Unit
  def isEnd(): Boolean
}

@Builder
class TargettedAnimationPlayer(
    startAt: Location,
    target: TargetType,
    animation: Animation
) extends AnimationPlayer {

  val ctx = AnimationContext(startAt, target)

  override def play(): Unit = {
    this.animation.tick(ctx)
    this.animation.play()
  }

  def remove(): Unit = this.animation.remove()

  override def isEnd(): Boolean = this.animation.isEnd()

}

@Builder
class NoTargettedAnimationPlayer(startAt: Location, animation: Animation)
    extends TargettedAnimationPlayer(startAt, TargetType.None, animation)
