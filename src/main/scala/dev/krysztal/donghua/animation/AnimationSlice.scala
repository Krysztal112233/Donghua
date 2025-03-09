package dev.krysztal.donghua.animation

trait AnimationSlice {
  def playAt(): Int
  def play(ctx: AnimationContext): Unit
  def onRemove(): Unit = {}
}
