package io.gomint.server.inventory.item;
import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 180 )
 public class ItemRedSandstoneStairs extends ItemStack implements io.gomint.inventory.item.ItemRedSandstoneStairs {



    @Override
    public String getBlockId() {
        return "minecraft:red_sandstone_stairs";
    }

    @Override
    public ItemType getType() {
        return ItemType.RED_SANDSTONE_STAIRS;
    }

}
