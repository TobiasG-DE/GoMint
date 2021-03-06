package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:glowingobsidian", id = 246)
public class ItemGlowingObsidian extends ItemStack implements io.gomint.inventory.item.ItemGlowingObsidian {

    @Override
    public ItemType getItemType() {
        return ItemType.GLOWING_OBSIDIAN;
    }

}
