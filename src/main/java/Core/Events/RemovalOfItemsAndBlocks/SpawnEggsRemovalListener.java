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
import cn.nukkit.utils.TextFormat;
import Core.Main;

public class SpawnEggsRemovalListener implements Listener {

  private Main plugin;
  private int itemID = 383;
  private Item spawnegg = Item.get(383);

  /**
   * Constructor
   */
  public SpawnEggsRemovalListener(Main plugin) {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    this.plugin.getLogger().debug("SpawnEggsRemovalListener enabled");
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    Player name = event.getPlayer();
    if (!(name.isOp())) {
      Item item = name.getInventory().getItemInHand();
      if (item.getId() == itemID) {
        event.setCancelled();
        name.sendChat(TextFormat.RED + "You are not allowed to use this item.");
      }
    }
  }


  // TODO Add removal on chest open and close
}
