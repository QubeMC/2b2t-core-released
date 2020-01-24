/*
 *  Copyright (C) 2B2TMCBE™ - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by maxxie114 <maxxie114@mxpersonal.com> & possibly edited by EPFFORCE <epfforce@danwin1210.me>, 17/11/2019, 04:09
 *
 */
package Core.Events.JoinLeaveMessage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerRespawnEvent;
import cn.nukkit.level.Location;
import cn.nukkit.utils.TextFormat;
import Core.Main;

public class OnPlayerJoinEvent implements Listener {

  private Main plugin;

  private String[] msg = new String[] {"to Hell!", "to this absolute Madness!",
      "to a place full of chaos!", "to Enjoy this Insanity!", "to Despair!"};

  /**
   * Constructor
   *
   * @param plugin
   */
  public OnPlayerJoinEvent(Main plugin) {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
  }


  @EventHandler(priority = EventPriority.LOWEST)
  public void onJoin(PlayerJoinEvent event) {
    Random rnd = new Random();
    int choice = rnd.nextInt(msg.length);
    Player player = event.getPlayer();
    String name = event.getPlayer().getName();
    if (player.isOp()) {
      event.setJoinMessage(TextFormat.RED + "Everyone, Welcome " + name + " " + msg[choice]);
      event.getPlayer().sendMessage("Hi Admin! Welcome back to 2b2tMCPE!");
    } else {
      // event.setJoinMessage(TextFormat.RED + "Welcome back " + name + " to 2b2t, just... with a
      // twist...");
      event.setJoinMessage(TextFormat.RED + "Everyone, Welcome " + name + " " + msg[choice]);
    }
  }

  @EventHandler(priority = EventPriority.LOWEST)
  public void onRespawn(PlayerRespawnEvent ev) {
    this.createFixedUserList();
    ArrayList<String> fixedusr = new ArrayList<String>();
    String fixusrLst = "/home/ubuntu/fixList/fixedUser.txt";
    String fileName = "/home/ubuntu/fixList/BrokenAccount.txt";
    
    Scanner s = null;
    // read from BrokenAccount.txt
    try {
      s = new Scanner(new File(fileName));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ArrayList<String> list = new ArrayList<String>();
    while (s.hasNext()) {
      list.add(s.next());
    }
    s.close();

    // read from fixedUser.txt
    try {
      Scanner sc = new Scanner(new File(fixusrLst));
      while (sc.hasNext()) {
        fixedusr.add(sc.next());
      }
      s.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    for (String i : list) {
      String uname = i;
      Player juply = ev.getPlayer();
      if (juply.getName().equalsIgnoreCase(uname) && !(fixedusr.contains(uname))) {
        // Create a random number generator
        Random rnd = new Random();
        // define x, y, and z positions
        int x = rnd.nextInt(1000);
        int z = rnd.nextInt(1000);
        int y = ev.getPlayer().getLevel().getHighestBlockAt(x, z) + 3;
        Location pos = new Location(x, y, z, juply.getLevel());

        ev.setRespawnPosition(pos);
        // plugin.getServer().getLogger().info("new pos: " + juply.getPosition()); // debug
        this.writePlayerToList(uname, fixusrLst);
      }
    }
  }

  /**
   * This function create the fixedUser.txt file that store names of everyone who are already fixed
   * This function only create file if it doesn't exist
   */
  public void createFixedUserList() {
    String fileName = "/home/ubuntu/fixList/fixedUser.txt";
    File file = new File(fileName);
    if (!(file.exists())) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Another function to write a playername into a file
   * @param playername
   * @param filename
   */
  public void writePlayerToList(String playername, String filename) {
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(filename, true));
      out.write(playername);
      out.newLine();
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
