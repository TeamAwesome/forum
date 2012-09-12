package com.forum.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrivilegeTest {

    @Test
    public void shouldReturnAdminPrivilege(){
        int valueForAdmin = 1;
        Privilege privilege = Privilege.getPrivilege(valueForAdmin);

        assertThat(privilege, is(Privilege.ADMIN));
    }

    @Test
    public void shouldReturnUserPrivilege(){
        int valueForUser = 13;
        Privilege privilege = Privilege.getPrivilege(valueForUser);

        assertThat(privilege, is(Privilege.USER));
    }
}
