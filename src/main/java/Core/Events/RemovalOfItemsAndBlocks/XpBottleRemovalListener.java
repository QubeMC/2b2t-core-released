/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Jan 25, 2019
 */
package Core.Events.RemovalOfItemsAndBlocks;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;
import Core.Main;

public class XpBottleRemovalListener implements Listener {

  private Main plugin;
  private Item xpBottle = Item.get(384);
  private int itemID = 384;

  /**
   * Constructor
   */
  public XpBottleRemovalListener(Main plugin) {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    this.plugin.getLogger().debug("XpBottleRemovalListener enabled");
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    Player name = event.getPlayer();
    Item item = name.getInventory().getItemInHand();
    if (item.getId() == itemID) {
      event.setCancelled();
      name.getInventory().remove(xpBottle);
      // name.sendChat(TextFormat.RED + "You are not allowed to use this item.");
    }
  }

  // TODO Add removal on chest open and close
}
