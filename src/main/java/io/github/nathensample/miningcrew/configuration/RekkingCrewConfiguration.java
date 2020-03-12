package io.github.nathensample.miningcrew.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RekkingCrewConfiguration {

    @Value("${authClientId:#{null}}")
    private String clientId;

    @Value("${authClientSecret:#{null}}")
    private String clientSecret;

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
