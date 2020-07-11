/*
 * Copyright (c) 2017, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.world;

import io.gomint.server.util.PerformanceHacks;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

/**
 * @author geNAZt
 * @version 1.0
 */
public class NibbleArray {

    /**
     * Allocates a new nibble array that is able to hold length entries.
     *
     * @param size The desired length of the array
     */
    static NibbleArray create( short size ) {
        return new NibbleArray( size );
    }

    private final int length;
    private final ByteBuf data;

    /**
     * Allocates a new nibble array that is able to hold length entries.
     *
     * @param length The desired length of the array
     */
    public NibbleArray( short length ) {
        this.length = length;
        this.data = PooledByteBufAllocator.DEFAULT.directBuffer(( this.length + 1 ) >> 1);
    }

    /**
     * Sets the entry at the specified index
     *
     * @param index The index of the nibble to be set
     * @param value The value to set
     */
    public void set( int index, byte value ) {
        value &= 0xF;

        byte old = this.data.getByte(index / 2);
        old &= (byte) ( 0xF << ( ( index + 1 ) % 2 * 4 ) );
        old |= (byte) ( value << ( index % 2 * 4 ) );
        this.data.setByte( index / 2, old );
    }

    /**
     * Gets the entry at the specified index
     *
     * @param index The index of the nibble to get
     * @return The nibble's value
     */
    public byte get( int index ) {
        return (byte) ( this.data.getByte(index / 2) >> ( ( index & 1 ) << 2 ) & 0xF );
    }

    /**
     * Gets the length of the nibble array
     *
     * @return The length of the nibble array
     */
    public int length() {
        return this.length;
    }

    /**
     * Release this array
     */
    public void release() {
        this.data.release();
    }

}
