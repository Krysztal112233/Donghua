package org.example

import org.bukkit.plugin.java.JavaPlugin
import com.typesafe.scalalogging.Logger
import org.example.PluginEntry.logger

class PluginEntry extends JavaPlugin {
  override def onLoad(): Unit = {
    logger.info("Hello, world!")
  }
}

object PluginEntry {
  final val logger = Logger("Example")
}
