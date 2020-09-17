package io.openmarket.client;

import io.openmarket.account.grpc.AccountGrpc;
import io.openmarket.account.grpc.AccountService;
import io.openmarket.client.config.ConnectionConfig;
import io.openmarket.client.factory.ChannelFactory;

import javax.annotation.Nonnull;

public class OpenMarketAuthClient {
    private final AccountGrpc.AccountBlockingStub blockingStub;

    public OpenMarketAuthClient() {
        this.blockingStub = AccountGrpc.newBlockingStub(ChannelFactory.getChannel(ConnectionConfig.host, ConnectionConfig.port));
    }

    public AccountService.RegistrationResult register(@Nonnull AccountService.RegistrationRequest registerRequest) {
        AccountService.RegistrationResult result;
        result = this.blockingStub.handleRegister(registerRequest);
        return result;
    }

    public AccountService.LoginResult getAuthToken (@Nonnull AccountService.LoginRequest loginRequest) {
        AccountService.LoginResult result;
        result = this.blockingStub.handleLogin(loginRequest);
        return result;
    }
}
