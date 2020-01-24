/*
 *  Copyright (C) 2B2TMCBE™ - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by maxxie114 <maxxie114@mxpersonal.com> & possibly edited by EPFFORCE <epfforce@danwin1210.me>, 17/11/2019, 03:49
 *
 */
package Core.Events.CommandRemoval;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.lang.TranslationContainer;
import cn.nukkit.utils.TextFormat;
import Core.Main;

public class CommandRemoveListener implements Listener {

  private Main plugin;

  /**
   * Constructor
   *
   * @param plugin plugin
   */
  public CommandRemoveListener(Main plugin) {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  // /ban /ban-ip /kick /deop /op /tp /me
  @EventHandler
  public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
    String[] cmdLst = {"/ban", "/kill", "/ban-ip", "/kick", "/deop", "/op", "/me", "/help", "/mute", "/sudo"};
    String cmd = event.getMessage();
    for (String i : cmdLst) {
      if (cmd.contains(i)) {
        event.setCancelled(true);
        event.getPlayer().sendMessage(
            new TranslationContainer(TextFormat.RED + "%commands.generic.unknown", cmd));
      }
    }
  }
}
