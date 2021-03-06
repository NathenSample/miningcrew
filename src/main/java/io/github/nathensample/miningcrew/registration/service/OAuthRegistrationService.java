package io.github.nathensample.miningcrew.registration.service;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import io.github.nathensample.miningcrew.registration.exception.LazyDebuggingBlameNathenException;
import io.github.nathensample.miningcrew.registration.model.AccessTokenResponse;
import io.github.nathensample.miningcrew.registration.model.AuthTokenExchange;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;

@Service
public class OAuthRegistrationService
{
    //TODO: Extract to property file
    private static final GenericUrl EVE_TOKEN_SERVER = new GenericUrl("https://login.eveonline.com/oauth/token");

    public AccessTokenResponse exchangeAuthTokenForAccessToken(String oauthToken, String clientId, String secretKey)
    {
        //TODO: Don't new here, have a resource we share, check to see if its alive, else reinitialise
        return exchangeAuthTokenForAccessToken(oauthToken, EVE_TOKEN_SERVER, clientId, secretKey, new NetHttpTransport(), new JacksonFactory());
    }

    AccessTokenResponse exchangeAuthTokenForAccessToken(String oauthToken, GenericUrl genericUrl, String clientId, String secretKey, HttpTransport httpTransport, JsonFactory jsonFactory)
    {
        try
            {
                HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
                HttpContent httpContent = new JsonHttpContent(jsonFactory, new AuthTokenExchange(oauthToken));
                HttpRequest request = requestFactory.buildPostRequest(genericUrl, httpContent);
                //TODO: Extract UA to property file
                request.getHeaders().setUserAgent("MiningCrew | Christy Cloud");
                request.getHeaders().setContentType("application/json");
                request.getHeaders().set("Authorization", "Basic " + base64Encode(clientId, secretKey));

                return request.execute().parseAs(AccessTokenResponse.class);
            } catch (IOException e)
            {
                throw new LazyDebuggingBlameNathenException(e);
            }
    }

    private String base64Encode(String clientId, String secretKey)
    {
        final String buffer = clientId + ":" + secretKey;
        return Base64.getEncoder().encodeToString(buffer.getBytes());

    }
}
