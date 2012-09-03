package com.forum.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import sun.security.x509.AuthorityInfoAccessExtension;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class LoginHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Collection grantedAuthorities = authentication.getAuthorities();
        GrantedAuthority grantedAuthority = (GrantedAuthority) grantedAuthorities.toArray()[0];
        String authority = grantedAuthority.getAuthority();

        if(authority.equals("ROLE_ADMIN")){
            httpServletResponse.sendRedirect("adminDashboard");
        } else if (authority.equals("ROLE_USER")){
            httpServletResponse.sendRedirect("");
        }
    }
}
