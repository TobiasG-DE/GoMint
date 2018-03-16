package io.gomint.plugin.listener;

import io.gomint.GoMint;
import io.gomint.entity.potion.PotionEffect;
import io.gomint.event.EventHandler;
import io.gomint.event.EventListener;
import io.gomint.event.player.PlayerJoinEvent;
import io.gomint.inventory.item.*;
import io.gomint.plugin.TestPlugin;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.TimeUnit;

/**
 * @author geNAZt
 * @version 1.0
 */
@RequiredArgsConstructor
public class PlayerJoinListener implements EventListener {

    private final TestPlugin plugin;

    @EventHandler
    public void onPlayerJoin( PlayerJoinEvent event ) {
        event.getPlayer().teleport( GoMint.instance().getDefaultWorld().getSpawnLocation().clone().add( 0, 1, 0 ) );
        // event.getPlayer().setGamemode( Gamemode.CREATIVE );

        event.getPlayer().getInventory().setItem( 0, ItemBeacon.create( 1 ) );
        event.getPlayer().getInventory().setItem( 1, ItemIronPickaxe.create( 1 ) );

        event.getPlayer().getInventory().setItem( 2, ItemEnderPearl.create( 16 ) );
        event.getPlayer().getInventory().setItem( 3, ItemGoldenApple.create( 64 ) );

        event.getPlayer().getInventory().setItem( 4, ItemBlockOfIron.create( 12 ) );

        ItemBucket waterBucket = ItemBucket.create( 1 );
        waterBucket.setContent( ItemBucket.Content.WATER );
        event.getPlayer().getInventory().setItem( 5, waterBucket );

        event.getPlayer().getInventory().setItem( 6, ItemBed.create( 1 ) );
        event.getPlayer().getInventory().setItem( 7, ItemAcaciaWoodDoor.create( 1 ) );

        event.getPlayer().addEffect( PotionEffect.SPEED, 0, 30, TimeUnit.MINUTES );

        this.plugin.getScheduler().schedule( () -> event.getPlayer().removeAllEffects(), 15, TimeUnit.SECONDS );
    }

}
