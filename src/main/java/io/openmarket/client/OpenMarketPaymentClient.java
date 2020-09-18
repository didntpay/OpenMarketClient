package io.openmarket.client;

import io.openmarket.client.factory.ChannelFactory;
import io.openmarket.client.config.ConnectionConfig;
import io.openmarket.client.credential.model.CredentialProvider;
import io.openmarket.transaction.grpc.TransactionGrpc;
import io.openmarket.transaction.grpc.TransactionProto.*;
import lombok.NonNull;

public class OpenMarketPaymentClient extends AbstractOpenMarketClient {
    private final TransactionGrpc.TransactionBlockingStub stub;
    public OpenMarketPaymentClient(@NonNull final CredentialProvider credentialProvider) {
        super(credentialProvider);
        this.stub = TransactionGrpc.newBlockingStub(ChannelFactory
                .getChannel(ConnectionConfig.host, ConnectionConfig.port)
        ).withCallCredentials(getCallCredentials());
    }

    public QueryResult query(@NonNull final QueryRequest request) {
        return stub.processQuery(request);
    }

    public PaymentResult createPayment(@NonNull final PaymentRequest request) {
        return stub.processPayment(request);
    }

    public RefundResult refundPayment(@NonNull final RefundRequest request) {
        return stub.processRefund(request);
    }
}
