package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.math.Location;
import io.gomint.server.entity.EntityLiving;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.server.world.block.state.BooleanBlockState;
import io.gomint.server.world.block.state.DirectionBlockState;
import io.gomint.world.block.BlockSoulCampfire;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.Direction;
import io.gomint.world.block.data.Facing;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo( sId = "minecraft:soul_campfire" )
public class SoulCampfire extends Block implements BlockSoulCampfire {

    private static final DirectionBlockState DIRECTION = new DirectionBlockState(() -> new String[]{"direction"}); // Rotation is always clockwise
    private static final BooleanBlockState EXTINGUISHED = new BooleanBlockState(() -> new String[]{"extinguished"});

    @Override
    public boolean beforePlacement(EntityLiving entity, ItemStack item, Facing face, Location location) {
        super.beforePlacement(entity, item, face, location);
        DIRECTION.detectFromPlacement(this, entity, item, face);
        EXTINGUISHED.setState(this, false);
        return true;
    }

    @Override
    public long getBreakTime() {
        return 3000;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public float getBlastResistance() {
        return 10.0f;
    }

    @Override
    public Class<? extends ItemStack>[] getToolInterfaces() {
        return ToolPresets.AXE;
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.SOUL_CAMPFIRE;
    }

    @Override
    public void setDirection(Direction direction) {
        DIRECTION.setState(this, direction);
    }

    @Override
    public Direction getDirection() {
        return DIRECTION.getState(this);
    }

    @Override
    public void setExtinguished(boolean value) {
        EXTINGUISHED.setState(this, value);
    }

    @Override
    public boolean isExtinguished() {
        return EXTINGUISHED.getState(this);
    }

}
