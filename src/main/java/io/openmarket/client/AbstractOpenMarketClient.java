package io.openmarket.client;

import io.grpc.CallCredentials;
import io.openmarket.client.credential.BearerToken;
import io.openmarket.client.credential.model.CredentialProvider;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

public abstract class AbstractOpenMarketClient {
    @Getter(AccessLevel.PROTECTED)
    private final CallCredentials callCredentials;

    public AbstractOpenMarketClient(@NonNull final CredentialProvider credentialProvider) {
        this.callCredentials = new BearerToken().withToken(credentialProvider.provideCredential());
    }
}
