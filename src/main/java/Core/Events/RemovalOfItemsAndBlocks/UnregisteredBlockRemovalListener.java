/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Feb 19, 2019
 */
package Core.Events.RemovalOfItemsAndBlocks;

import java.util.ArrayList;
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

public class UnregisteredBlockRemovalListener implements Listener {

  // 247-249 255

  private Main plugin;

  Item item1 = Item.get(247);
  Item item2 = Item.get(248);
  Item item3 = Item.get(249);
  Item item4 = Item.get(255);

  Block block1 = Block.get(247);
  Block block2 = Block.get(248);
  Block block3 = Block.get(249);
  Block block4 = Block.get(255);

  ArrayList<Item> itemLst = new ArrayList<Item>();
  ArrayList<Block> blockLst = new ArrayList<Block>();

  public UnregisteredBlockRemovalListener(Main plugin) {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);

    itemLst.add(item1);
    itemLst.add(item2);
    itemLst.add(item3);
    itemLst.add(item4);

    blockLst.add(block1);
    blockLst.add(block2);
    blockLst.add(block3);
    blockLst.add(block4);
  }

  /**
   * On Place Event
   *
   * @param event
   */
  @EventHandler
  public void OnPlace(BlockPlaceEvent event) {

    Player p = event.getPlayer();
    if (!p.isOp()) {
      for (int i = 0; i < 4; i++) {
        if (event.getBlock().getId() == blockLst.get(i).getId()) {
          event.setCancelled(true);
          p.getInventory().remove(itemLst.get(i));
          p.sendMessage(TextFormat.RED + "illegal block/item removed");
        }
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
      for (int i = 0; i < 4; i++) {
        if (p.getInventory().contains(itemLst.get(i))) {
          p.getInventory().remove(itemLst.get(i));
          p.sendMessage(TextFormat.DARK_RED + "illegal block/item removed");

        } else if (event.getInventory().contains(itemLst.get(i))) {
          event.getInventory().remove(itemLst.get(i));
          p.sendMessage(TextFormat.RED + "illegal block/item removed");
        }
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
      for (int i = 0; i < 4; i++) {
        if (p.getInventory().contains(itemLst.get(i))) {
          p.getInventory().remove(itemLst.get(i));
          p.sendMessage(TextFormat.DARK_RED + "illegal block/item removed");
        } else if (event.getInventory().contains(itemLst.get(i))) {
          event.getInventory().remove(itemLst.get(i));
          p.sendMessage(TextFormat.RED + "illegal block/item removed");
        }
      }
    }
  }
}
