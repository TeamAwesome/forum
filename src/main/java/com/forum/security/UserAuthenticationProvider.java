package com.forum.security;

import com.forum.domain.User;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private UserService userService;
    private static final Logger logger = Logger.getLogger(UserAuthenticationProvider.class.getName());

    @Autowired
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        throw new RuntimeException();
//        try {
//            logger.info("Enter Authentication.");
//            User user = new User();
//            user.setUsername((String) authentication.getPrincipal());
//            user.setPassword((String) authentication.getPrincipal());
//            User userValidated = userService.getValidation(user);
//
//            if(userValidated==null){
//                 throw new BadCredentialsException("User or password failed.");
//            }
//
//
//
//        // Implement the userService logic
//        //            userService.authenticateAndReturnUser((String) authentication.getPrincipal(),(String) authentication.getCredentials());
//            List<? extends GrantedAuthority> grantedAuthorities = Arrays.asList(new GrantedAuthority() {
//                @Override
//                public String getAuthority() {
//                    return "USER";
//                }
//            });
//
//            return new UsernamePasswordAuthenticationToken(
//                    authentication.getPrincipal(),
//                    authentication.getCredentials(),
//                    grantedAuthorities
//            );
//        } catch (Exception e) {
//                throw new BadCredentialsException("Bad User Credentials.");
//        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
