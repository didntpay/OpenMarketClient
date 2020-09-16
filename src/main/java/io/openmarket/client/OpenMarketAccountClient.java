package io.openmarket.client;

import io.openmarket.account.grpc.AccountGrpc;
import io.openmarket.account.grpc.AccountService.*;
import io.openmarket.client.factory.ChannelFactory;
import io.openmarket.client.config.ConnectionConfig;
import lombok.Data;
import lombok.extern.log4j.Log4j2;


import javax.inject.Inject;

@Data
@Log4j2
public final class OpenMarketAccountClient {

    private final AccountGrpc.AccountBlockingStub blockingStub;
    private final AccountGrpc.AccountStub asyncStub;

    @Inject
    public OpenMarketAccountClient() {
        this.blockingStub = AccountGrpc.newBlockingStub(ChannelFactory.getChannel(ConnectionConfig.host, ConnectionConfig.port));
        this.asyncStub = AccountGrpc.newStub(ChannelFactory.getChannel(ConnectionConfig.host, ConnectionConfig.port));
        System.out.println(blockingStub.toString());
        System.out.println(asyncStub.toString());
    }

    public RegistrationResult register(RegistrationRequest registerRequest) {
        RegistrationResult result;
        result = this.blockingStub.handleRegister(registerRequest);
        return result;
    }

    public LoginResult login (LoginRequest loginRequest) {
        LoginResult result;
        result = this.blockingStub.handleLogin(loginRequest);
        return result;
    }


}
