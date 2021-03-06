/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.inventory.item;

import io.gomint.GoMint;

/**
 * @author geNAZt
 * @version 1.0
 * @stability 1
 */
public interface ItemJunglePressurePlate extends ItemStack, ItemBurnable {

    /**
     * Create a new item stack with given class and amount
     *
     * @param amount which is used for the creation
     */
    static ItemJunglePressurePlate create( int amount ) {
        return GoMint.instance().createItemStack( ItemJunglePressurePlate.class, amount );
    }

    @Override
    default long getBurnTime() {
        return 15000;
    }

}
