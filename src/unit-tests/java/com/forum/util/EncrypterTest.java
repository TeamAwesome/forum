package com.forum.util;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class EncrypterTest {

    @Test
    public void shouldEncrypt() throws NoSuchAlgorithmException {
        String password = "password";
        Encrypter encrypter = new Encrypter();
        String md5 = encrypter.encryptUsingMd5(password);
        assertNotNull(md5);
        assertThat(md5, not(password));
    }
}
