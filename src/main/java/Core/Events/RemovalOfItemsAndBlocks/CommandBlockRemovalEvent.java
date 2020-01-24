/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package Core.Events.RemovalOfItemsAndBlocks;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.inventory.InventoryCloseEvent;
import cn.nukkit.event.inventory.InventoryOpenEvent;
import cn.nukkit.item.Item;
import cn.nukkit.utils.TextFormat;
import Core.Main;

public class CommandBlockRemovalEvent implements Listener {

  private Main plugin;

  public CommandBlockRemovalEvent(Main plugin) {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
  }
  //  Impulse Command Block	command_block	137
  //  Chain Command Block	chain_command_block	189
  //  Repeating Command Block	repeating_command_block	188

  Item item = new Item(137);
  final int block = 137;

  Item item1 = new Item(189);
  final int block1 = 189;

  Item item2 = new Item(188);
  final int block2 = 188;


  /**
   *
   * @param event
   */
  @EventHandler
  public void OnPlace(BlockPlaceEvent event) {
    Player p = event.getPlayer();
    if (!p.isOp()) {
      if (event.getBlock().getId() == block || event.getBlock().getId() == block1
          || event.getBlock().getId() == block2) {
        event.setCancelled(true);
        switch (event.getBlock().getId()) { //I Added a Switch Statement because i don't know if it would throw a error removing the wrong item/block?
          case block: {
            p.getInventory().remove(item);
          }
          case block1: {
            p.getInventory().remove(item1);
          }
          case block2: {
            p.getInventory().remove(item2);
          }
          default:
        }
        p.sendMessage(TextFormat.DARK_RED + "illegal block/item removed");
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
      if (p.getInventory().contains(item) || p.getInventory().contains(item1)
          || p.getInventory().contains(item2)) {

        if (p.getInventory().contains(item)) {
          p.getInventory().remove(item);
        }
        if (p.getInventory().contains(item1)) {
          p.getInventory().remove(item1);
        }
        if (p.getInventory().contains(item2)) {
          p.getInventory().remove(item2);
        }
        p.sendMessage(TextFormat.DARK_RED + "illegal block/item removed");

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
      if (p.getInventory().contains(item) || p.getInventory().contains(item1)
          || p.getInventory().contains(item2)) {

        if (p.getInventory().contains(item)) {
          p.getInventory().remove(item);
        }
        if (p.getInventory().contains(item1)) {
          p.getInventory().remove(item1);
        }
        if (p.getInventory().contains(item2)) {
          p.getInventory().remove(item2);
        }
        p.sendMessage(TextFormat.DARK_RED + "illegal block/item removed");
      }
    }
  }
}
