package com.forum.sercurity;

import com.forum.domain.Privilege;
import com.forum.domain.User;
import com.forum.security.UserAuthenticationProvider;
import com.forum.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserAuthenticationProviderTest {

    private UserAuthenticationProvider userAuthenticationProvider;
    private UserService mockUserService;

    @Before
    public void setup(){
        userAuthenticationProvider = new UserAuthenticationProvider();
        mockUserService = mock(UserService.class);
    }

    @Test
    public void shouldPassAuthentication(){
        Authentication mockAuthentication = mock(Authentication.class);
        userAuthenticationProvider.setUserService(mockUserService);
        String username = "maomao";
        String password = "pw";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User userWithPrivilege = new User();
        userWithPrivilege.setUsername(username);
        userWithPrivilege.setPassword(password);
        when(mockAuthentication.getPrincipal()).thenReturn(username);
        when(mockAuthentication.getCredentials()).thenReturn(password);
        when(mockUserService.getValidation(user)).thenReturn(userWithPrivilege);
        when(mockUserService.getRole(user)).thenReturn(Privilege.ADMIN);
        Authentication authentication =  userAuthenticationProvider.authenticate(mockAuthentication);

        assertThat((String)authentication.getPrincipal(), is("maomao"));
        assertThat((String)authentication.getCredentials(), is("pw"));
        Collection grantedAuthorities = authentication.getAuthorities();
        assertThat(grantedAuthorities.size(), is(1));
        GrantedAuthority grantedAuthority = (GrantedAuthority) grantedAuthorities.toArray()[0];
        assertThat(grantedAuthority.getAuthority(), is("ROLE_ADMIN"));
    }
}
