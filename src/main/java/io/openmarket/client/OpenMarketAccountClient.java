package io.openmarket.client;

import io.openmarket.account.grpc.AccountGrpc;
import io.openmarket.account.grpc.AccountService.*;
import io.openmarket.client.credential.model.CredentialProvider;
import io.openmarket.client.factory.ChannelFactory;
import io.openmarket.client.config.ConnectionConfig;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;


import javax.annotation.Nonnull;
import javax.inject.Inject;

@Data
@Log4j2
public final class OpenMarketAccountClient extends AbstractOpenMarketClient{

    private final AccountGrpc.AccountBlockingStub blockingStub;
    private final AccountGrpc.AccountStub asyncStub;

    @Inject
    public OpenMarketAccountClient(@NonNull final CredentialProvider credentialProvider) {
        super(credentialProvider);
        this.blockingStub = AccountGrpc.newBlockingStub(ChannelFactory.getChannel(ConnectionConfig.host, ConnectionConfig.port))
                .withCallCredentials(getCallCredentials());
        this.asyncStub = AccountGrpc.newStub(ChannelFactory.getChannel(ConnectionConfig.host, ConnectionConfig.port));
    }




}
