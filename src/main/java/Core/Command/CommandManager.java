/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Jan 13, 2019
 */
package Core.Command;

import cn.nukkit.command.CommandMap;
import Core.Main;

public class CommandManager {

  /**
   * This function make the process of registering command easier.
   *
   * @param plugin
   */
  public static void regAllCmds(Main plugin) {
    CommandMap map = plugin.getServer().getCommandMap();
    map.register("Core", new BackCommand("back", plugin));
    map.register("Core", new EndCommand("end", plugin));
    map.register("Core", new GmspCommand("gmsp", plugin));
    map.register("Core", new SuicideCommand("suicide", plugin));
  }

}
