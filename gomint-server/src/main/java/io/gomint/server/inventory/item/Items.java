package io.gomint.server.inventory.item;

import com.google.common.reflect.ClassPath;
import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.Generator;
import io.gomint.server.registry.Registry;
import io.gomint.server.registry.SkipRegister;
import io.gomint.server.util.performance.ObjectConstructionFactory;
import io.gomint.taglib.NBTTagCompound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author geNAZt
 * @version 1.0
 */
@SkipRegister
public class Items {

    private static final Logger LOGGER = LoggerFactory.getLogger( Items.class );
    private final Registry<io.gomint.server.inventory.item.ItemStack> generators;

    /**
     * Create a new item registry
     *
     * @param classPath which builds this registry
     */
    public Items( ClassPath classPath ) {
        this.generators = new Registry<>( classPath, clazz -> {
            ObjectConstructionFactory factory = new ObjectConstructionFactory( clazz );
            return () -> (io.gomint.server.inventory.item.ItemStack) factory.newInstance();
        } );

        this.generators.register( "io.gomint.server.inventory.item" );
    }

    public <T extends ItemStack> T create( String id, short data, byte amount, NBTTagCompound nbt ) {
        // Add a way to get block ids to integer ids for conversion into a item stack
        return (T) new ItemAir(); // TODO: Build a proper implementation
    }

    /**
     * Create a new item stack based on a id
     *
     * @param id     of the type for this item stack
     * @param data   for this item stack
     * @param amount in this item stack
     * @param nbt    additional data for this item stack
     * @param <T>    type of item stack
     * @return generated item stack
     */
    public <T extends ItemStack> T create( int id, short data, byte amount, NBTTagCompound nbt ) {
        Generator<io.gomint.server.inventory.item.ItemStack> itemGenerator = this.generators.getGenerator( id );
        if ( itemGenerator == null ) {
            LOGGER.warn( "Unknown item {}", id );
            return null;
        }

        // Cleanup NBT tag, root must be empty string
        if ( nbt != null && !nbt.getName().isEmpty() ) {
            nbt = nbt.deepClone( "" );
        }

        io.gomint.server.inventory.item.ItemStack itemStack = itemGenerator.generate();
        itemStack.setNbtData( nbt ).setMaterial( id ).setData( data );

        if ( amount > 0 ) {
            return (T) itemStack.setAmount( amount );
        }

        return (T) itemStack;
    }

    /**
     * Create a new item stack based on a api interface
     *
     * @param itemClass which defines what item to use
     * @param amount    in this item stack
     * @param <T>       type of item stack
     * @return generated item stack
     */
    public <T extends ItemStack> T create( Class<T> itemClass, byte amount ) {
        Generator<io.gomint.server.inventory.item.ItemStack> itemGenerator = this.generators.getGenerator( itemClass );
        if ( itemGenerator == null ) {
            return null;
        }


        io.gomint.server.inventory.item.ItemStack itemStack = itemGenerator.generate();
        itemStack.setMaterial( this.generators.getId( itemClass ) );

        if ( amount > 0 ) {
            itemStack.setAmount( amount );
        }

        return (T) itemStack.setData( (short) 0 );
    }

}
