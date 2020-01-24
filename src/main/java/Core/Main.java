package Core;
/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Max Xie <maxxie114@mxpersonal.com>, Nov 14, 2018 
 */

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import Core.Command.CommandManager;
import Core.Events.EventsManager;

/**
 * Core.Main class
 */
public class Main extends PluginBase implements Listener {

  @Override
  public void onEnable() {
    regEvents();
    regCommands();
    this.getLogger().info(TextFormat.GREEN + "2b2tmcpeCore enabled");
    this.saveDefaultConfig();
    loadEnd();
  }

  @Override
  public void onDisable() {
    this.getLogger().info(TextFormat.RED + "2b2tmcpeCore disabled");
  }

  /**
   * This method will register all commands
   */
  public void regCommands() {
    CommandManager.regAllCmds(this);
  }

  /**
  
  /**
  test
  */
   * This method will register all events
   */
  public void regEvents() {
    EventsManager.registerAllEvents(this);
    this.getServer().getPluginManager().registerEvents(this, this);
  }

  /**
   * This method will load the End world
   */
  public void loadEnd() {
    String worldName = "end";
    if (!(this.getServer().loadLevel(worldName))) {
      this.getServer().loadLevel(worldName);
    }
  }
}
