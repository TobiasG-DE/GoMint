package io.gomint.server.network.packet;

import io.gomint.jraknet.PacketBuffer;
import io.gomint.server.network.Protocol;
import lombok.Data;

/**
 * @author geNAZt
 * @version 1.0
 */
@Data
public class PacketClientCacheBlobStatus extends Packet {

    private long[] hit;
    private long[] miss;

    public PacketClientCacheBlobStatus() {
        super( Protocol.PACKET_CLIENT_CACHE_BLOB_STATUS );
    }

    @Override
    public void serialize(PacketBuffer buffer, int protocolID) {

    }

    @Override
    public void deserialize(PacketBuffer buffer, int protocolID) {
        int missCount = buffer.readUnsignedVarInt();
        int hitCount = buffer.readUnsignedVarInt();

        this.hit = new long[hitCount];
        this.miss = new long[missCount];

        for (int i = 0; i < missCount; i++) {
            this.miss[i] = buffer.readLLong();
        }

        for (int i = 0; i < hitCount; i++) {
            this.hit[i] = buffer.readLLong();
        }
    }
}
