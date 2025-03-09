package dev.krysztal.donghua.animation

import java.util.concurrent.CopyOnWriteArrayList

class AnimationScheduler extends Runnable {
  val animation: CopyOnWriteArrayList[AnimationPlayer] = CopyOnWriteArrayList()

  override def run(): Unit = {
    animation.forEach { animation =>
      animation.play()
      if (animation.isEnd()) { animation.remove() }
    }

    animation.removeIf(_.isEnd())
  }
}
