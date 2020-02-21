package io.github.nathensample.miningcrew.registration.model;

import com.google.api.client.util.Key;

public class AuthTokenExchange
{
    @Key("grant_type")
    private static final String GRANT_TYPE = "authorization_code";
    @Key
    private final String code;

    public AuthTokenExchange(final String code)
    {
        this.code = code;
    }
}
