package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo( sId = "minecraft:honeycomb", id = 736 )
public class ItemHoneyComb extends ItemStack implements io.gomint.inventory.item.ItemHoneyComb {

    @Override
    public ItemType getItemType() {
        return ItemType.HONEYCOMB;
    }
}