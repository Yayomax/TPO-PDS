package com.tuempresa.gestionpartidos.security.test;

import com.tuempresa.gestionpartidos.security.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JwtTokenProviderTest {
    @Test
    void testGenerarYValidarToken() {
        JwtTokenProvider jwt = new JwtTokenProvider();
        String token = jwt.generarToken("usuario@correo.com");
        assertNotNull(token);
        assertTrue(jwt.validarToken(token));
        assertEquals("usuario@correo.com", jwt.getUsernameFromToken(token));
    }

    @Test
    void testTokenInvalido() {
        JwtTokenProvider jwt = new JwtTokenProvider();
        assertFalse(jwt.validarToken("token-falso"));
    }
}
