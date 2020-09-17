package io.openmarket.client.factory;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ChannelFactory {
    private static ManagedChannel channel = null;

    public static ManagedChannel getChannel(String host, int port) {
        if (channel == null)
            channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        return channel;
    }
}
