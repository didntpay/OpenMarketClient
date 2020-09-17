package io.openmarket.client.credential.model;

/**
 * CredentialProvider provides credential for server to authenticate client.
 */
public interface CredentialProvider {
    /**
     * Provide a credential.
     * @return a String representing the credential provided.
     */
    String provideCredential();
}
