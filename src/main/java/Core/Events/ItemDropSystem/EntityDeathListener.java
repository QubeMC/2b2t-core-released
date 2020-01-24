/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Jun 12, 2019
 */
package Core.Events.ItemDropSystem;

import java.util.Random;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDeathEvent;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.item.Item;
import Core.Main;

public class EntityDeathListener implements Listener {

  private Main plugin;

  /**
   * Constructor
   *
   * @param Main plugin
   */
  public EntityDeathListener(Main plugin) {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  /*
   * This function is an EventHandler for the EntityDeathEvent
   * 
   * @param EntityDeathEvent event
   */
  @EventHandler
  public void onEntityDeath(EntityDeathEvent event) {
    // debug
    plugin.getLogger().debug("debug: EntityDeathEvent called");

    // Get original drops
    Item[] drops = event.getDrops();

    // Create a chance system and make it 20% chance
    // 1/5 = 20%
    String[] chances = {"no", "yes", "no", "no", "no"};
    Random rnd = new Random();

    // Generate random number
    int rndNum = rnd.nextInt(5);

    /*
     * Create item list that contains these:
     * Elytra
     * Shulkerbox
     * Tridents
     * Crystals
     * dragon egg
     * enchanted golden apple
     */
    Item elytra = new Item(Item.ELYTRA);
    Item shulkerbox = new Item(Item.SHULKER_BOX);
    Item trident = new Item(Item.TRIDENT);
    Item dragonEgg = new Item(Item.DRAGON_EGG);
    Item crystal = new Item(Item.END_CRYSTAL);
    Item enchantedApple = new Item(Item.GOLDEN_APPLE_ENCHANTED);

    Item[] rareItemLst = new Item[6];
    rareItemLst[0] = elytra;
    rareItemLst[1] = shulkerbox;
    rareItemLst[2] = trident;
    rareItemLst[3] = dragonEgg;
    rareItemLst[4] = crystal;
    rareItemLst[5] = enchantedApple;

    if (chances[rndNum].equals("yes")) {
      Item rareItem = rareItemLst[rnd.nextInt(6)];
      // Since array is fix length, we create a new array and add all items from the first array to the second
      Item[] newDropLst = new Item[drops.length + 1];
      for (int i = 0; i < drops.length; i++) {
        newDropLst[i] = drops[i];
      }
      newDropLst[drops.length] = rareItem;
      event.setDrops(newDropLst);
    }
    plugin.getLogger().debug("debug: " + chances[rndNum]); // debug
    plugin.getLogger().debug("debug: number = " + rndNum); // debug
  }


  /*
   * This function is an EventHandler for the PlayerDeathEvent
   * 
   * @param PlayerDeathEvent event
   */
  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent event) {
    // test code
    plugin.getLogger().debug("debug: PlayerDeathEvent called");

    // Get original drops
    Item[] drops = event.getDrops();

    // Create a chance system and make it 20% chance
    // 1/5 = 20%
    String[] chances = {"no", "yes", "no", "no", "no"};
    Random rnd = new Random();

    // Generate random number
    int rndNum = rnd.nextInt(5);

    /*
     * Create item list that contains these:
     * Elytra
     * Shulkerbox
     * Tridents
     * Crystals
     * dragon egg
     * enchanted golden apple
     */
    Item elytra = new Item(Item.ELYTRA);
    Item shulkerbox = new Item(Item.SHULKER_BOX);
    Item trident = new Item(Item.TRIDENT);
    Item dragonEgg = new Item(Item.DRAGON_EGG);
    Item crystal = new Item(Item.END_CRYSTAL);
    Item enchantedApple = new Item(Item.GOLDEN_APPLE_ENCHANTED);

    Item[] rareItemLst = new Item[6];
    rareItemLst[0] = elytra;
    rareItemLst[1] = shulkerbox;
    rareItemLst[2] = trident;
    rareItemLst[3] = dragonEgg;
    rareItemLst[4] = crystal;
    rareItemLst[5] = enchantedApple;

    if (chances[rndNum].equals("yes")) {
      Item rareItem = rareItemLst[rnd.nextInt(6)];
      // Since array is fix length, we create a new array and add all items from the first array to the second
      Item[] newDropLst = new Item[drops.length + 1];
      for (int i = 0; i < drops.length; i++) {
        newDropLst[i] = drops[i];
      }
      newDropLst[drops.length] = rareItem;
      event.setDrops(newDropLst);
    }
    plugin.getLogger().debug("debug: " + chances[rndNum]); // debug
    plugin.getLogger().debug("debug: number = " + rndNum); // debug
  }

}
