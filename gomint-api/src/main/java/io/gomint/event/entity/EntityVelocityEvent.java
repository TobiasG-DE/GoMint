/*
 * Copyright (c) 2018, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.event.entity;

import io.gomint.entity.Entity;
import io.gomint.math.Vector;

/**
 * @author geNAZt
 * @version 1.0
 */
public class EntityVelocityEvent extends CancellableEntityEvent {

    private Vector velocity;

    /**
     * Create a new entity based cancellable event
     *
     * @param entity for which this event is
     * @param velocity which should be applied to the given entity
     */
    public EntityVelocityEvent( Entity entity, Vector velocity ) {
        super( entity );
        this.velocity = velocity;
    }

    /**
     * Get the velocity
     *
     * @return the applied velocity
     */
    public Vector getVelocity() {
        return this.velocity;
    }

    /**
     * Set new velocity
     *
     * @param velocity which should be applied to the entity
     */
    public void setVelocity( Vector velocity ) {
        this.velocity = velocity;
    }

}