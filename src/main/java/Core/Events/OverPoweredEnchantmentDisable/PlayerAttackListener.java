/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Oct 18, 2019
 */
package Core.Events.OverPoweredEnchantmentDisable;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import Core.Main;

public class PlayerAttackListener implements Listener {

    private Main plugin;

    /**
     * Constructor
     *
     * @param Main plugin
     */
    public PlayerAttackListener(Main plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    /**
     * This function is an EventListener for EntityDamageByEntityEvent
     *
     * @param event
     */
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent ev) {
        Entity damager = ev.getDamager();
        if ((damager instanceof Player)) {
            // This part is for reverting item on hand
            Item item = ((Player) ev.getDamager()).getInventory().getItemInHand(); //get the item in hand
            Enchantment[] enchantments = item.getEnchantments();
            for (Enchantment ecmt : enchantments) {
                int maxLevel = ecmt.getMaxLevel();
                if (ecmt.getLevel() > maxLevel) {
                    ecmt.setLevel(maxLevel, true);
                    //          ev.setDamage(0);
                    //          ev.setKnockBack(0);
                    ev.setCancelled(true);
                    // item.setCustomName("new item 2");
                    item.addEnchantment(new Enchantment[]{ecmt});
                    ((Player) ev.getDamager()).getInventory().setItemInHand(item);
                }
            }
            // This part is for reverting item that players wear
            // chestplate
            Item chestplate = ((Player) ev.getDamager()).getInventory().getChestplate();
            Enchantment[] enchantmentsChest = chestplate.getEnchantments();
            for (Enchantment ecmtChest : enchantmentsChest) {
                int maxLevel = ecmtChest.getMaxLevel();
                int level = ecmtChest.getLevel();
                //        System.out.println("maxlevel:" + maxLevel);
                if (level > maxLevel) {
                    // debug
          /*
          plugin.getServer()
              .broadcastMessage("OldEcmtName:"
                  + ((Player) ev.getDamager()).getInventory().getChestplate().getEnchantments()[0]
                      .getName());
          plugin.getServer()
              .broadcastMessage("OldEcmtLvl:"
                  + ((Player) ev.getDamager()).getInventory().getChestplate().getEnchantments()[0]
                      .getLevel());
          */
                    ecmtChest.setLevel(maxLevel, true);
                    //          ev.setDamage(0);
                    //          ev.setKnockBack(0);
                    ev.setCancelled(true);
                    //          chestplate.setCustomName("new chestplate");
                    chestplate.addEnchantment(new Enchantment[]{ecmtChest});
                    ((Player) ev.getDamager()).getInventory().setChestplate(chestplate);
                    // debug
          /*
          plugin.getServer().broadcastMessage("MaxLvl:" + ecmtChest.getMaxLevel());
          plugin.getServer().broadcastMessage("NewItemName: "
              + ((Player) ev.getDamager()).getInventory().getChestplate().getName());
          plugin.getServer()
              .broadcastMessage("NewEcmtLvl:"
                  + ((Player) ev.getDamager()).getInventory().getChestplate().getEnchantments()[0]
                      .getLevel());
          */
                }
            }
            // leggings
            Item leggings = ((Player) ev.getDamager()).getInventory().getLeggings();
            Enchantment[] enchantmentsLeg = leggings.getEnchantments();
            for (Enchantment ecmtLeg : enchantmentsLeg) {
                int maxLevel = ecmtLeg.getMaxLevel();
                if (ecmtLeg.getLevel() > maxLevel) {
                    ecmtLeg.setLevel(maxLevel, true);
                    //          ev.setDamage(0);
                    //          ev.setKnockBack(0);
                    ev.setCancelled(true);
                    //          leggings.setCustomName("new leggings");
                    leggings.addEnchantment(new Enchantment[]{ecmtLeg});
                    ((Player) ev.getDamager()).getInventory().setLeggings(leggings);
                }
            }
            // boots
            Item boots = ((Player) ev.getDamager()).getInventory().getBoots();
            Enchantment[] enchantmentsBoot = boots.getEnchantments();
            for (Enchantment ecmtBoot : enchantmentsBoot) {
                int maxLevel = ecmtBoot.getMaxLevel();
                if (ecmtBoot.getLevel() > maxLevel) {
                    ecmtBoot.setLevel(maxLevel, true);
                    //          ev.setDamage(0);
                    //          ev.setKnockBack(0);
                    ev.setCancelled(true);
                    //          boots.setCustomName("new boots");
                    boots.addEnchantment(new Enchantment[]{ecmtBoot});
                    ((Player) ev.getDamager()).getInventory().setBoots(boots);
                }
            }
            // helmet
            Item helmet = ((Player) ev.getDamager()).getInventory().getHelmet();
            Enchantment[] enchantmentsHelm = helmet.getEnchantments();
            for (Enchantment ecmtHelm : enchantmentsHelm) {
                int maxLevel = ecmtHelm.getMaxLevel();
                if (ecmtHelm.getLevel() > maxLevel) {
                    ecmtHelm.setLevel(maxLevel, true);
                    // ev.setDamage(0);
                    //           ev.setKnockBack(0);
                    ev.setCancelled(true);
                    // helmet.setCustomName("new helmet");
                    helmet.addEnchantment(new Enchantment[]{ecmtHelm});
                    ((Player) ev.getDamager()).getInventory().setHelmet(helmet);
                }
            }

        }
    }

}
