/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.enchant;

import io.gomint.enchant.Rarity;
import io.gomint.server.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(id = 4)
public class EnchantmentProjectileProtection extends Enchantment implements io.gomint.enchant.EnchantmentProjectileProtection {

    /**
     * Create new enchantment projectile protection
     */
    public EnchantmentProjectileProtection() {
        super((short) 4);
    }

    @Override
    public int getMinEnchantAbility(short level) {
        return (byte) (3 + (level - 1) * 6);
    }

    @Override
    public int getMaxEnchantAbility(short level) {
        return (byte) (getMinEnchantAbility(level) + 15);
    }

    @Override
    public boolean canBeApplied(ItemStack itemStack) {
        return EnchantmentHelper.canBeAppliedArmor(itemStack);
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public boolean collidesWith(Enchantment enchantment) {
        return enchantment instanceof EnchantmentProtection ||
            enchantment instanceof EnchantmentFireProtection ||
            enchantment instanceof EnchantmentBlastProtection ||
            super.collidesWith(enchantment);
    }

}
