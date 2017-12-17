package io.gomint.entity.passive;

import io.gomint.GoMint;
import io.gomint.entity.EntityLiving;

public interface EntityRabbit extends EntityLiving {

    /**
     * Create a new entity donkey with no config
     *
     * @return empty, fresh rabbit
     */

    static EntityCow create() {
        return GoMint.instance().createEntity( EntityCow.class );
    }

}
