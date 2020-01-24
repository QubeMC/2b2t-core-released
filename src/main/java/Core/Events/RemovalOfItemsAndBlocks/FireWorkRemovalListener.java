/*
 *  Copyright (C) 2B2TMCBE™ - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by maxxie114 <maxxie114@mxpersonal.com> & possibly edited by EPFFORCE <epfforce@danwin1210.me>, 17/11/2019, 04:07
 *
 */

package Core.Events.RemovalOfItemsAndBlocks;

import Core.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;

public class FireWorkRemovalListener implements Listener {
    private Main plugin;
    private Item FireWork = Item.get(401);
    private int itemID = 401;

    /**
     * Constructor
     */
    public FireWorkRemovalListener(Main plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
        this.plugin.getLogger().debug("FireWorkRemovalListener enabled");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player name = event.getPlayer();
        Item item = name.getInventory().getItemInHand();
        if (item.getId() == itemID) {
            event.setCancelled(true);
            name.getInventory().remove(FireWork);
            // name.sendChat(TextFormat.RED + "You are not allowed to use this item.");
        }
    }

    // TODO Add removal on chest open and close
}
