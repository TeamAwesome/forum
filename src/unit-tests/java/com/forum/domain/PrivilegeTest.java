package com.forum.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrivilegeTest {

    @Test
    public void shouldReturnAdminPrivilege(){
        Privilege privilege = Privilege.getPrivilege(1);

        assertThat(privilege, is(Privilege.ADMIN));
    }

    @Test
    public void shouldReturnUserPrivilege(){
        Privilege privilege = Privilege.getPrivilege(13);

        assertThat(privilege, is(Privilege.USER));
    }
}
