package com.forum.sercurity;

import com.forum.domain.User;
import com.forum.security.TempUserAuthenticationProvider;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TempUserAuthenticationProviderTest {
    private TempUserAuthenticationProvider tempUserAuthenticationProvider;

    @Before
    public void setup(){
        this.tempUserAuthenticationProvider = new TempUserAuthenticationProvider();
    }

    @Test
    public void shouldPassAuthentication(){
        Authentication mockAuthentication = mock(Authentication.class);
        String username = "Jules";
        String password = "Great!";
        when(mockAuthentication.getPrincipal()).thenReturn(username);
        when(mockAuthentication.getCredentials()).thenReturn(password);

        Authentication authentication =  tempUserAuthenticationProvider.authenticate(mockAuthentication);

        assertThat((String)authentication.getPrincipal(), is("Jules"));
        assertThat((String)authentication.getCredentials(), is("Great!"));
        Collection grantedAuthorities = authentication.getAuthorities();
        assertThat(grantedAuthorities.size(), is(1));
        GrantedAuthority grantedAuthority = (GrantedAuthority) grantedAuthorities.toArray()[0];
        assertThat(grantedAuthority.getAuthority(), is("ROLE_ADMIN"));
    }
}
