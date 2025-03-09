package dev.krysztal.donghua.animation

import scala.collection.mutable.Queue

trait Animation {
  def isEnd(): Boolean
  def play(): Unit
  def setPause(pause: Boolean): Unit
  def tick(ctx: AnimationContext): Unit

  def remove(): Unit
}

class CompositeAnimation private (
    private val slices: Queue[AnimationSlice],
    private var initialCtx: AnimationContext,
    private val onRemove: () => Unit = () => {}
) extends Animation {
  private var paused: Boolean = false
  private var ticked: Int = 0
  private var currentCtx: AnimationContext | Null = null

  override def isEnd(): Boolean = this.slices.size <= 0

  override def play(): Unit = {
    if (!this.paused) {
      val scheduledSlice = slices.dequeueWhile(_.playAt() <= this.ticked)
      val ctx =
        if (this.currentCtx == null) { initialCtx }
        else { currentCtx.asInstanceOf[AnimationContext] }

      scheduledSlice.foreach(_.play(ctx))
    }
  }

  override def setPause(pause: Boolean): Unit = this.paused = pause

  override def tick(delta: AnimationContext): Unit = if (!this.paused) {
    this.ticked += 1
    this.currentCtx = delta
  }

  override def remove(): Unit = this.onRemove()
}
