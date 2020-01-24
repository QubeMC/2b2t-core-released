/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Dec 22, 2018
 */

package Core.Events.JoinLeaveMessage;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.utils.TextFormat;
import Core.Main;

public class OnPlayerQuitEvent implements Listener {

  private Main plugin;

  /**
   * Constructor
   * @param plugin
   */
  public OnPlayerQuitEvent(Main plugin) {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    Player player = event.getPlayer();
    String name = event.getPlayer().getName();
    if (player.isOp()) {
      event.setQuitMessage(TextFormat.RED + "Awesome! " + name + " left hell and went to heaven!");
    } else {
      event.setQuitMessage(TextFormat.RED + "Awesome! " + name + " left hell and went to heaven!");
    }
  }

}
