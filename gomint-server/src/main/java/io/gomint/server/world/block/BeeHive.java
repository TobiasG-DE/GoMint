package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.math.Location;
import io.gomint.server.entity.EntityLiving;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.server.world.block.state.BlockfaceFromPlayerBlockState;
import io.gomint.server.world.block.state.ProgressBlockState;
import io.gomint.world.block.BlockBeeHive;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.Facing;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:beehive")
public class BeeHive extends Block implements BlockBeeHive {

    private static final BlockfaceFromPlayerBlockState FACING = new BlockfaceFromPlayerBlockState(() -> new String[]{"facing_direction"}, false);
    private static final ProgressBlockState HONEY_LEVEL = new ProgressBlockState(() -> new String[]{"honey_level"}, 5, aVoid -> {
    });

    @Override
    public long getBreakTime() {
        return 450;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public float getBlastResistance() {
        return 0.6f;
    }

    @Override
    public Class<? extends ItemStack>[] getToolInterfaces() {
        return ToolPresets.AXE;
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.BEE_HIVE;
    }

    @Override
    public boolean beforePlacement(EntityLiving entity, ItemStack item, Facing face, Location location) {
        FACING.detectFromPlacement(this, entity, item, face);
        HONEY_LEVEL.detectFromPlacement(this, entity, item, face);
        return super.beforePlacement(entity, item, face, location);
    }

    @Override
    public void setFacing(Facing facing) {
        FACING.setState(this, facing);
    }

    @Override
    public Facing getFacing() {
        return FACING.getState(this);
    }

}
