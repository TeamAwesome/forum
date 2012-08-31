package com.forum.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class UserAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = Logger.getLogger(UserAuthenticationProvider.class.getName());

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        try {
            logger.info("Enter Authentication.");
            if (!authentication.getPrincipal().equals("maomao")) throw new RuntimeException();


        // Implement the userService logic
        //            userService.authenticateAndReturnUser((String) authentication.getPrincipal(),(String) authentication.getCredentials());
            List<? extends GrantedAuthority> grantedAuthorities = Arrays.asList(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_USER";
                }
            });

            return new UsernamePasswordAuthenticationToken(
                    authentication.getPrincipal(),
                    authentication.getCredentials(),
                    grantedAuthorities
            );
        } catch (Exception e) {
            throw new BadCredentialsException("Bad User Credentials.");
        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
