package com.forum.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.List;

public class TempUserAuthenticationProvider  implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if(authentication.getPrincipal().equals("Jules") && authentication.getCredentials().equals("Great!")){
            List<? extends GrantedAuthority> grantedAuthorities = Arrays.asList(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_ADMIN";
                }
            });
            return new UsernamePasswordAuthenticationToken(
                    authentication.getPrincipal(),
                    authentication.getCredentials(),
                    grantedAuthorities
            );
        }

        throw new BadCredentialsException("Bad User Credentials.");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
