/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Feb 19, 2019
 */
package Core.Events.RemovalOfItemsAndBlocks;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.inventory.InventoryCloseEvent;
import cn.nukkit.event.inventory.InventoryOpenEvent;
import cn.nukkit.item.Item;
import cn.nukkit.utils.TextFormat;
import Core.Main;

public class MobSpawnerRemovalListener implements Listener {

  private Main plugin;

  public MobSpawnerRemovalListener(Main plugin) {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
  }

  Item item = new Item(Item.MONSTER_SPAWNER);
  int block = Block.MONSTER_SPAWNER;


  /**
   * On Place Event
   *
   * @param event
   */
  @EventHandler
  public void OnPlace(BlockPlaceEvent event) {
    Player p = event.getPlayer();
    if (!p.isOp()) {
      if (event.getBlock().getId() == block) {
        event.setCancelled(true);
        p.getInventory().remove(item);
        p.sendMessage(TextFormat.RED + "illegal block/item removed");
      }
    }
  }

  /**
   * On Chest Open Event
   *
   * @param event
   */
  @EventHandler
  public void OnChestOpened(InventoryOpenEvent event) {
    Player p = event.getPlayer();

    if (!(p.isOp())) {
      if (p.getInventory().contains(item)) {
        p.getInventory().remove(item);
        p.sendMessage(TextFormat.DARK_RED + "illegal block/item removed");

      } else if (event.getInventory().contains(item)) {
        event.getInventory().remove(item);
        p.sendMessage(TextFormat.RED + "illegal block/item removed");
      }

    }
  }

  /**
   * On Chest Close Event
   *
   * @param event
   */
  @EventHandler
  public void OnChestClosed(InventoryCloseEvent event) { // EVENT
    Player p = event.getPlayer();
    if (!(p.isOp())) {
      if (p.getInventory().contains(item)) {
        p.getInventory().remove(item);
        p.sendMessage(TextFormat.DARK_RED + "illegal block/item removed");
      } else if (event.getInventory().contains(item)) {
        event.getInventory().remove(item);
        p.sendMessage(TextFormat.RED + "illegal block/item removed");
      }
    }
  }
}
