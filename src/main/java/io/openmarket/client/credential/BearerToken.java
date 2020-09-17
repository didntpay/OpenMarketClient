package io.openmarket.client.credential;

import io.grpc.CallCredentials;
import io.grpc.Metadata;
import io.grpc.Status;
import io.openmarket.config.GlobalConfig;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.concurrent.Executor;

@With
@NoArgsConstructor
@AllArgsConstructor
public class BearerToken extends CallCredentials {
    private String token;

    @Override
    public void applyRequestMetadata(RequestInfo requestInfo, Executor appExecutor, MetadataApplier applier) {
        appExecutor.execute(() -> {
            try {
                Metadata headers = new Metadata();
                headers.put(Metadata.Key.of("AuthToken",
                        Metadata.ASCII_STRING_MARSHALLER), token);
                applier.apply(headers);
            } catch (Throwable e) {
                applier.fail(Status.UNAUTHENTICATED.withCause(e));
            }
        });
    }

    @Override
    public void thisUsesUnstableApi() {}
}
