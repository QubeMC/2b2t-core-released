/*
 *  Copyright (C) 2B2TMCBE™ - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by maxxie114 <maxxie114@mxpersonal.com> & possibly edited by EPFFORCE <epfforce@danwin1210.me>, 17/11/2019, 04:07
 *
 */
package Core.Events;

import Core.Main;
import Core.Events.CommandRemoval.CommandRemoveListener;
import Core.Events.DeathMessages.PlayerDeathListener;
// import Core.Events.DimensionChangeAssist.LevelChangeEventsListeners;
// import Core.Events.ForBackCommand.BackOnDeathEvent;
// import Core.Events.ForBackCommand.BackOnJoinEvent;
// import Core.Events.ForBackCommand.BackPlayerQuitEvent;
import Core.Events.ItemDropSystem.EntityDeathListener;
import Core.Events.JoinLeaveMessage.OnPlayerJoinEvent;
import Core.Events.JoinLeaveMessage.OnPlayerQuitEvent;
import Core.Events.OverPoweredEnchantmentDisable.PlayerAttackListener;
import Core.Events.RemovalOfItemsAndBlocks.CommandBlockRemovalEvent;
import Core.Events.RemovalOfItemsAndBlocks.MobSpawnerRemovalListener;
import Core.Events.RemovalOfItemsAndBlocks.SpawnEggsRemovalListener;
import Core.Events.RemovalOfItemsAndBlocks.XpBottleRemovalListener;
import Core.Events.RemovalOfItemsAndBlocks.FireWorkRemovalListener;
import Core.Events.SignTextLimit.SignUpdateListener;
//import Core.Events.BrokenAcct.onPlayerJoinEvnt;

public class EventsManager {

  /**
   * This is a method to register all command, it make register events easier, and less modification
   * are needed.
   *
   * @param plugin plugin
   */
  public static void registerAllEvents(Main plugin) {
    // new EndGatewayRemovalEvent(plugin);
    // new BedrockRemovalEvent(plugin);
    // new InvisibleBedrockRemovalEvent(plugin);
    new OnPlayerJoinEvent(plugin);
    new OnPlayerQuitEvent(plugin);
    new CommandBlockRemovalEvent(plugin);
    // new BackOnDeathEvent(plugin);
    // new BackPlayerQuitEvent(plugin);
    // new BackOnJoinEvent(plugin);
    new MovementCheckEvents(plugin);
    // new LevelChangeEventsListeners(plugin);
    new OnPlayerDeathEvents(plugin);
    new SpawnEggsRemovalListener(plugin);
    new XpBottleRemovalListener(plugin);
    new PlayerDeathListener(plugin);
    new MobSpawnerRemovalListener(plugin);
    // new UnregisteredBlockRemovalListener(plugin);
    new CommandRemoveListener(plugin);
    new SignUpdateListener(plugin);
    new EntityDeathListener(plugin);
    new EntityDeathListener(plugin);
    new PlayerAttackListener(plugin);
    new FireWorkRemovalListener(plugin);
//    new onPlayerJoinEvnt(plugin);
  }
}
