/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Feb 8, 2019
 */
package Core.Api;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.entity.EntityDamageEvent.DamageCause;
import Core.Main;

public class CustomDeathMessageAPI {
  Main plugin = new Main();

  /**
   * This class determine the death message of each death case, it will only return the part of the
   * Death message that is after the name of the victim, however, this will not affect the message 
   * of player attack another player.
   * @param cause
   * @return the death message for different cases except ENTITY_EXPLOSION and PROJECTILE
   */
  public String getDeathMessage(DamageCause cause) {
    String result;
    switch (cause) {
      case SUFFOCATION:
        result = "trapped himself in a wall";
        break;
      case FALL:
        result = "Accidentally jumped from top of the empire state building";
        break;
      case FIRE:
        result = "consume by hell";
        break;
      case FIRE_TICK:
        result = "consume by hell";
        break;
      case LAVA:
        result = "Jumped into a volcano";
        break;
      case DROWNING:
        result = "Didn't know how to swim";
        break;
      case BLOCK_EXPLOSION:
        result = "Blown to pieces";
        break;
      case LIGHTNING:
        result = "Electrocuted by the wrath of god";
        break;
      case VOID:
        result = "went over the edge";
        break;
      case SUICIDE:
        result = "could not go any longer";
        break;
      case MAGIC:
        result = "Died from some supernatural force";
        break;
      case HUNGER:
        result = "Couldn't handle a hunger strike";
        break;
      default:
        result = "died from unknown reason";
    }
    return result;
  }

  /**
   * This function return the death message for case ENTITY_EXPLOSION
   * @param cause
   * @param damager
   * @return the death message for enum case ENTITY_EXPLOSION
   */
  public String getEntityExplosionDeathMessage(DamageCause cause, Entity damager) {
    String result = "was blown to pieces by " + damager.getName();
    return result;
  }

  /**
   * @param cause
   * @param damager
   * @return the death message for enum case PROJECTILE
   */
  public String getProjectileDeathMessage(DamageCause cause, Entity damager) {
    String result = "got oofed by some Unidentified flying object sent by " + damager.getName();

      return result;
  }

}
