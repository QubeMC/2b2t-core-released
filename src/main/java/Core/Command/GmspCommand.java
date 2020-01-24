/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Nov 14, 2018 
 */

package Core.Command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import Core.Main;

public class GmspCommand extends Command {

  private Main main;

  public GmspCommand(String name, Main main) {
    super(name);
    this.setDescription("This command will allow you to go to spectator mode.");
    this.main = main;
  }

  @Override
  public boolean execute(CommandSender sender, String commandLabel, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage(TextFormat.RED + "You can only run this command in game.");
      return false;
    } else if (!(sender.hasPermission("core.gmsp"))) {
      sender.sendMessage(TextFormat.RED + "You don't have permission to run this command.");
      return false;
    } else if (sender.isOp() || sender.hasPermission("core.gmsp")) {
      ((Player) sender).setGamemode(3);
      return true;
    } else {
      return false;
    }
  }
}
