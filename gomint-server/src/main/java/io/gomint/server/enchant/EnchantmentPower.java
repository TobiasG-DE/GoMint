/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.enchant;

import io.gomint.enchant.Rarity;
import io.gomint.inventory.item.ItemType;
import io.gomint.server.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 19 )
public class EnchantmentPower extends Enchantment implements io.gomint.enchant.EnchantmentPower {

    /**
     * Create new enchantment power
     */
    public EnchantmentPower() {
        super( (short) 5 );
    }

    @Override
    public int getMinEnchantAbility( short level ) {
        return (byte) ( 1 + ( level - 1 ) * 10 );
    }

    @Override
    public int getMaxEnchantAbility( short level ) {
        return (byte) ( getMinEnchantAbility( level ) + 15 );
    }

    @Override
    public boolean canBeApplied( ItemStack itemStack ) {
        return itemStack.getItemType() == ItemType.BOW;
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

}
