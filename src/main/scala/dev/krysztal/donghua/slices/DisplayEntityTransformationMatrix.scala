package dev.krysztal.donghua.animation

import lombok.Builder
import org.bukkit.entity.Display
import org.joml.Matrix4f

@Builder
case class DisplayEntityTransformationMatrix private (
    display: Display,
    at: Int,
    @Builder.Default
    matrix: Matrix4f = Matrix4f()
) extends AnimationSlice {
  override def playAt(): Int = this.at

  override def play(_ctx: AnimationContext): Unit = {
    display.setTransformationMatrix(matrix)
  }
}
