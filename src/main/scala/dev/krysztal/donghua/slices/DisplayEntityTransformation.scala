package dev.krysztal.donghua.animation

import lombok.Builder
import org.bukkit.entity.Display
import org.bukkit.util.Transformation
import org.joml.AxisAngle4f
import org.joml.Vector3f

@Builder
case class DisplayEntityTransformation private (
    display: Display,
    at: Int,
    @Builder.Default
    letfRotate: AxisAngle4f = AxisAngle4f(),
    @Builder.Default
    rightRotate: AxisAngle4f = AxisAngle4f(),
    @Builder.Default
    translation: Vector3f = Vector3f(),
    @Builder.Default
    scale: Vector3f = Vector3f()
) extends AnimationSlice {
  override def playAt(): Int = this.at

  override def play(_ctx: AnimationContext): Unit = {
    val transform = Transformation(translation, letfRotate, scale, rightRotate)
    display.setTransformation(transform)
  }
}
