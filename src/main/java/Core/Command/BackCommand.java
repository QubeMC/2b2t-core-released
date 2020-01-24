/* Copyright (C) 2B2TMCBE™ - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package Core.Command;

import Core.Main;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cn.nukkit.utils.TextFormat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackCommand extends Command {

    public static Map<String, List<Location>> deathMap = new HashMap<>();

    public BackCommand(String name, Main main) {
        super(name);
        this.setDescription("Use this to go back to your death location after you died.");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can only perform this command in-game!");
            return false;
        }

        Player p = (Player) sender;

        if (args.length == 0) {
            if (deathMap.get(p.getDisplayName()) == null) return true;
            p.sendMessage("You have " + deathMap.get(p.getDisplayName()).size() + " last death locations");
            for (Location i : deathMap.get(p.getDisplayName())) {
                p.sendMessage(TextFormat.GREEN + locationReaderBasic(i, deathMap.get(p.getDisplayName()).indexOf(i) + 1));
            }
            p.sendMessage("Usage: /back <Number>");
        }
        if (args.length >= 1) {
            if (deathMap.get(p.getDisplayName()) == null) return true;
            int number = stringToInteger(args[0]);
            if (number == 0) {
                number++;
            } else {
                number--;
            }
            boolean indexExists = number >= 0 && number < deathMap.get(p.getDisplayName()).size();
            if (!deathMap.get(p.getDisplayName()).isEmpty() && indexExists) {
                Location location = deathMap.get(p.getDisplayName()).get(number);
                p.teleport(location);
            } else {
                p.sendMessage(TextFormat.RED + "Hmm? something went wrong.");
            }
            return true;
        }
        return true;
    }

    public String locationReaderBasic(Location location, int indexOf) {
        int x = (int) location.getX();
        int y = (int) location.getY();
        int z = (int) location.getZ();
        String worldname = location.getLevel().getName();

        return indexOf + ". (" + z + ", " + y + ", " + z + ", " + worldname + ")";
    }

    public int stringToInteger(String string) {
        int done;
        try {
            done = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return 0;
        }
        return done;
    }
}

