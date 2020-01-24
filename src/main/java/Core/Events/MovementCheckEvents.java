/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Jan 13, 2019
 */
package Core.Events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerKickEvent;
import cn.nukkit.event.player.PlayerKickEvent.Reason;
import cn.nukkit.event.player.PlayerLoginEvent;
import Core.Main;

public class MovementCheckEvents implements Listener {

  private Reason reason;

  public MovementCheckEvents(Main plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void onLogin(PlayerLoginEvent event) {
    event.getPlayer().setCheckMovement(false);
  }


  @EventHandler(priority = EventPriority.LOWEST)
  public void onPlayerKick(PlayerKickEvent event) {
    reason = event.getReasonEnum();
    // This check is used to prevent fly hack kick
    if (reason == Reason.FLYING_DISABLED) {
      event.setCancelled();
    }
  }

}
