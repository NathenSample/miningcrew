package io.github.nathensample.miningcrew.registration.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessTokenResponse
{

    private final String accessToken;
    private final String tokenType;
    private final long expiresIn;
    private final String refreshToken;

    @JsonCreator
    public AccessTokenResponse(@JsonProperty("access_token") final String accessToken,
                               @JsonProperty("token_type") final String tokenType,
                               @JsonProperty("expires_in") final long expiresIn,
                               @JsonProperty("refresh_token") final String refreshToken)
    {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public String getTokenType()
    {
        return tokenType;
    }

    public long getExpiresIn()
    {
        return expiresIn;
    }

    public String getRefreshToken()
    {
        return refreshToken;
    }
}
