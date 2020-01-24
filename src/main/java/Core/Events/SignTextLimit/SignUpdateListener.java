/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Apr 9, 2019
 */
package Core.Events.SignTextLimit;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.SignChangeEvent;
import Core.Main;

public class SignUpdateListener implements Listener {

  private Main plugin;

  /**
   * Constructor
   */
  public SignUpdateListener(Main plugin) {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
  }

  @EventHandler
  public void onSignUpdate(SignChangeEvent event) {
    String[] textArr = event.getLines();
    String signText = String.join("", textArr);
    if (signText.length() > 176) {
      event.setCancelled(true);
    }
    plugin.getLogger().debug("SignChangeEvent called."); //debug
    plugin.getLogger().debug("Sign Message: " + signText); //debug
  }
}
