package io.gomint.server.inventory.item;
import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 48 )
 public class ItemMossyCobblestone extends ItemStack implements io.gomint.inventory.item.ItemMossyCobblestone {



    @Override
    public String getBlockId() {
        return "minecraft:mossy_cobblestone";
    }

    @Override
    public ItemType getType() {
        return ItemType.MOSSY_COBBLESTONE;
    }

}
