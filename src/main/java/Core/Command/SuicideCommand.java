/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Mar 23, 2019
 */
package Core.Command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.entity.EntityDamageEvent.DamageCause;
import cn.nukkit.utils.TextFormat;
import Core.Main;

public class SuicideCommand extends Command {

  private Main plugin;

  /**
   * Constructor
   */
  public SuicideCommand(String name, Main main) {
    super(name);
    this.plugin = main;
    this.setDescription("This command will allow you to suicide.");
  }

  @Override
  public boolean execute(CommandSender sender, String commandLabel, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage(TextFormat.RED + "You must be in game to perform this command.");
      return false;
    } else {
      EntityDamageEvent dmg = new EntityDamageEvent((Player) sender, DamageCause.SUICIDE, 1000);
      sender.getServer().getPluginManager().callEvent(dmg);
      sender.sendMessage(TextFormat.RED + "You have been killed.");
      ((Player) sender).setLastDamageCause(dmg);
      ((Player) sender).setHealth(0);
      return true;
    }
  }

}
