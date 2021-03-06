package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:clay", id = 82)
public class ItemClay extends ItemStack implements io.gomint.inventory.item.ItemClay {

    @Override
    public ItemType getItemType() {
        return ItemType.CLAY;
    }

}
