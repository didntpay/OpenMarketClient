package io.openmarket.client.credential.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@NoArgsConstructor
@AllArgsConstructor
public class SimpleTokenWrapper implements CredentialProvider {
    private String token;

    @Override
    public String provideCredential() {
        return token;
    }
}
