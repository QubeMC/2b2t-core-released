/*
 *  Copyright (C) 2B2TMCBE™ - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by maxxie114 <maxxie114@mxpersonal.com> & possibly edited by EPFFORCE <epfforce@danwin1210.me>, 21/10/2019, 17:06
 *
 */
package Core.Events;

import Core.Main;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;

public class OnPlayerDeathEvents extends PluginBase implements Listener {

    /**
     * Constructor
     */
  public OnPlayerDeathEvents(Main plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

//  @EventHandler(priority = EventPriority.LOWEST)
//  public void onPlayerDamage(EntityDamageEvent event) {
//    if (event.getEntity() instanceof Player) {
//      Player name = (Player) event.getEntity();
//      Inventory inv = name.getInventory();
////      Item totem = new Item(Item.TOTEM);
//        Item totem = Item.get(450, 0, 1);
//        // This loop make sure the totem is actually inside the player's hotbar
//        for (int i = 0; i <= 9; i++) {
//            if (inv.getItem(i).getId() == Item.TOTEM) {
//                name.setHealth(20);
//                name.sendMessage(TextFormat.GREEN + "Your totem saved your life!");
//                name.getInventory().remove(totem);
//                event.setCancelled(true);
//        }
//      }
//    }
//  }
}
