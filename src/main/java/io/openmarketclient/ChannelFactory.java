package io.openmarketclient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerCall;
import io.openmarket.account.grpc.AccountService;

public class ChannelFactory {
    private static ManagedChannel channel = null;

    public static ManagedChannel getChannel(String host, int port) {
        if (channel == null)
            channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        return channel;
    }
}
