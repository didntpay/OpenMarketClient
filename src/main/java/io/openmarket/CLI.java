package io.openmarket;

import io.openmarket.account.grpc.AccountService;
import io.openmarket.client.OpenMarketAccountClient;

public class CLI {
    public static void main(String[] args) {
        OpenMarketAccountClient client = new OpenMarketAccountClient();
        System.out.println(client);
        System.out.println(client.register(AccountService.RegistrationRequest.newBuilder().setDisplayName("didntpay")
        .setUsername("weifeng2").setPassword("213").build()));
    }
}
