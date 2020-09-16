package io.openmarketclient;

import io.grpc.ManagedChannel;
import io.openmarketclient.ComponentClient.OpenMarketAccountClient;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpenMarketClient {
    @Getter
    OpenMarketAccountClient accountClient;
}
