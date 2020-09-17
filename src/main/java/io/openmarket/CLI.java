package io.openmarket;

import io.openmarket.account.grpc.AccountService.*;
import io.openmarket.client.OpenMarketAccountClient;
import io.openmarket.client.OpenMarketAuthClient;
import io.openmarket.client.OpenMarketPaymentClient;
import io.openmarket.client.credential.model.SimpleTokenWrapper;
import io.openmarket.transaction.grpc.TransactionProto;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class CLI {

    public static void main(String[] args) {
        OpenMarketAuthClient client = new OpenMarketAuthClient();
        client.register(RegistrationRequest.newBuilder().setUsername("weifeng1")
                .setPassword("123").setDisplayName("didntpay").build());
        LoginResult result = client.getAuthToken(LoginRequest.newBuilder().setPassword("123").setUsername("weifeng1").build());

        OpenMarketPaymentClient paymentClient = new OpenMarketPaymentClient(new SimpleTokenWrapper().withToken(result.getCred()));
        TransactionProto.QueryResult payments = paymentClient.query(TransactionProto.QueryRequest.newBuilder().setParam("5d4a2777-5f83-4d96-8013-907621069778")
                .setType(TransactionProto.QueryRequest.QueryType.TRANSACTION_ID).build());

        log.info(payments.getItemsList());
    }
}
