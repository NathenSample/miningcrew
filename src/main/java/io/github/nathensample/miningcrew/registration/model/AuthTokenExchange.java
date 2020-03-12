package io.github.nathensample.miningcrew.registration.model;

import com.google.api.client.util.Key;

public class AuthTokenExchange
{
    @Key
    private final String grant_type = "authorization_code";
    @Key
    private final String code;

    public AuthTokenExchange(final String code)
    {
        this.code = code;
    }
}
