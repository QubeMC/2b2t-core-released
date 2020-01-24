/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by maxxie114 <maxxie114@mxpersonal.com>, Jan 13, 2019
 */
package Core.Command;

import java.util.Random;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cn.nukkit.network.protocol.ChangeDimensionPacket;
import cn.nukkit.utils.TextFormat;
import Core.Main;

public class EndCommand extends Command {

  private Main main = new Main();
  private Random rnd = new Random();
  private Location pos;
  private String worldName;
  private int x = 0;
  private int y = 0;
  private int z = 0;

  /**
   * Constructor
   */
  public EndCommand(String name, Main main) {
    super(name);
    this.setDescription("This command will send you to the End.");
    this.main = main;
  }

  /*
   * DIMENSION_OVERWORLD = 0;
   * DIMENSION_NETHER = 1;
   * DIMENSION_THE_END = 2;
   */

  @Override
  public boolean execute(CommandSender sender, String commandLabel, String[] args) {
    // this.defaultLevelID = main.getServer().getDefaultLevel().getId();

    if (!(sender instanceof Player)) {
      sender.sendMessage(TextFormat.RED + "You can only run this command in game.");
      return false;
    } else if (((Player) sender).getLevel().getName().equals("end")) {
      sender.sendMessage(TextFormat.BLUE + "You are already in the End :/");
      return false;
    } else {
      // Change dimension
      ChangeDimensionPacket pk = new ChangeDimensionPacket();
      worldName = "end";
      pk.dimension = Level.DIMENSION_THE_END;
      pk.respawn = false;

      while (y <= 3) {
        // random Spawn
        // define x, y, and z positions
        x = rnd.nextInt(100);
        z = rnd.nextInt(100);
        y = this.main.getServer().getLevelByName(worldName).getHighestBlockAt(x, z) + 3;

        // test code
        // sender.sendMessage("y:" + y);
        pos = new Location(x, y, z, this.main.getServer().getLevelByName(worldName));
      }

      // reset
      y = 0;

      if (!(main.getServer().loadLevel(worldName))) {
        main.getServer().loadLevel(worldName);
      }
      ((Player) sender).dataPacket(pk);
      ((Player) sender).teleport(pos);
      return true;
    }
  }
}
