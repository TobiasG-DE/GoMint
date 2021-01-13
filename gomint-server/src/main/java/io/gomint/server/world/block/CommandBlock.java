package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.math.Location;
import io.gomint.server.entity.EntityLiving;
import io.gomint.server.entity.tileentity.CommandBlockTileEntity;
import io.gomint.server.entity.tileentity.TileEntity;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.state.BlockfaceBlockState;
import io.gomint.server.world.block.state.BooleanBlockState;
import io.gomint.taglib.NBTTagCompound;
import io.gomint.world.block.BlockCommandBlock;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.Facing;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:command_block")
public class CommandBlock extends ContainerBlock implements BlockCommandBlock {

    private static final BooleanBlockState CONDITIONAL = new BooleanBlockState(() -> new String[]{"conditional_bit"});
    private static final BlockfaceBlockState FACING = new BlockfaceBlockState( () -> new String[]{"facing_direction"});

    @Override
    public boolean beforePlacement(EntityLiving entity, ItemStack item, Facing face, Location location) {
        FACING.detectFromPlacement(this, entity, item, face);
        CONDITIONAL.setState(this, false);
        return super.beforePlacement(entity, item, face, location);
    }

    @Override
    public float getBlastResistance() {
        return 1.8E7f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.COMMAND_BLOCK;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public boolean needsTileEntity() {
        return true;
    }

    @Override
    TileEntity createTileEntity(NBTTagCompound compound) {
        super.createTileEntity(compound);
        return this.tileEntities.construct(CommandBlockTileEntity.class, compound, this, this.items);
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
