package io.github.nathensample.miningcrew.registration.endpoint;

import io.github.nathensample.miningcrew.registration.model.AccessTokenResponse;
import io.github.nathensample.miningcrew.registration.service.OAuthRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController
{
    /*
     * SSO URL because i'm lazy
     * https://login.eveonline.com/oauth/authorize?response_type=code&redirect_uri=http://localhost:8080/callback&client_id=9711369325f3444386c2b05936e319ec&scope=publicData esi-universe.read_structures.v1 esi-corporations.read_structures.v1 esi-industry.read_character_mining.v1 esi-industry.read_corporation_mining.v1
     */
    private static Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private OAuthRegistrationService oAuthRegistrationService;

    @GetMapping("/callback")
    public ResponseEntity<String> initialCallback(@RequestParam String code)
    {
        AccessTokenResponse accessTokenResponse = oAuthRegistrationService.exchangeAuthTokenForAccessToken(code);
        return new ResponseEntity<>(accessTokenResponse.getRefreshToken(), HttpStatus.OK);
    }
}
