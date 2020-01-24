/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Feb 8, 2019
 */
package Core.Events.DeathMessages;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.entity.EntityDamageEvent.DamageCause;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.utils.TextFormat;
import Core.Main;
import Core.Api.CustomDeathMessageAPI;

public class PlayerDeathListener implements Listener {

  private Main plugin;

  /**
   * Constructor
   *
   * @param Main plugin
   */
  public PlayerDeathListener(Main plugin) {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  /**
   * This function is an EventListener for PlayerDeathEvent
   *
   * @param event
   */
  @EventHandler
  public void onDeath(PlayerDeathEvent event) {
    String message = "died from unknown reason.";
    EntityDamageEvent ev = event.getEntity().getLastDamageCause();
    DamageCause cause = event.getEntity().getPlayer().getLastDamageCause().getCause();
    this.plugin.getLogger().debug("debug: cause=" + cause.name()); // test code
    // This part is for entity attack entity
    // Unable to put it into the API class cause it will error out for some reason
    if (ev instanceof EntityDamageByEntityEvent) {
      Entity damager = ((EntityDamageByEntityEvent) ev).getDamager();
      CustomDeathMessageAPI api = new CustomDeathMessageAPI();
      // This condition check is to prevent class cast exception caused by mob attack
      if ((damager instanceof Player) && !(cause == DamageCause.PROJECTILE)) {
        String itemName = ((Player) damager).getInventory().getItemInHand().getName();
        message = "is brutally destroyed by " + damager.getName() + " using " + itemName;
      } else if (cause == DamageCause.ENTITY_EXPLOSION) {
        message = api.getEntityExplosionDeathMessage(cause, damager);
      } else if (cause == DamageCause.PROJECTILE) {
        message = api.getProjectileDeathMessage(cause, damager);
      } else if (cause == DamageCause.LIGHTNING) {
        message = api.getDeathMessage(cause);
      } else if (cause == DamageCause.ENTITY_ATTACK && !(damager instanceof Player)) {
        message = "is brutally destroyed by " + damager.getName();
      }
    } else {
      CustomDeathMessageAPI api = new CustomDeathMessageAPI();
      message = api.getDeathMessage(cause);
    }
    String finalMsg = event.getEntity().getName() + " " + message;
    event.setDeathMessage(TextFormat.RED + finalMsg);
  }

}
