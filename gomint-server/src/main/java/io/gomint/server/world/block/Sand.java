package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemSand;
import io.gomint.inventory.item.ItemStack;
import io.gomint.inventory.item.data.SandType;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.server.world.block.state.EnumBlockState;
import io.gomint.world.block.BlockSand;
import io.gomint.world.block.BlockType;

import java.util.Collections;
import java.util.List;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:sand")
public class Sand extends Fallable implements BlockSand {

    private static final String[] SAND_TYPE = new String[]{"sand_type"};

    private enum SandTypeMagic {
        RED("red"),
        NORMAL("normal");

        private final String type;

        SandTypeMagic(String type) {
            this.type = type;
        }
    }

    private static final EnumBlockState<SandTypeMagic, String> TYPE = new EnumBlockState<>(newValue -> {
        return SAND_TYPE;
    }, SandTypeMagic.values(), v -> v.type, v -> {
        for (SandTypeMagic value : SandTypeMagic.values()) {
            if (value.type.equals(v)) {
                return value;
            }
        }

        return null;
    });

    @Override
    public long getBreakTime() {
        return 750;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public Class<? extends ItemStack>[] getToolInterfaces() {
        return ToolPresets.SHOVEL;
    }

    @Override
    public float getBlastResistance() {
        return 2.5f;
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.SAND;
    }

    @Override
    public void setType(SandType type) {
        SandTypeMagic newState = SandTypeMagic.valueOf(type.name());
        TYPE.setState(this, newState);
    }

    @Override
    public SandType getType() {
        return SandType.valueOf(TYPE.getState(this).name());
    }

    @Override
    public List<ItemStack> getDrops(ItemStack itemInHand) {
        ItemSand sand = ItemSand.create(1);
        sand.setType(this.getType());
        return Collections.singletonList(sand);
    }

}
