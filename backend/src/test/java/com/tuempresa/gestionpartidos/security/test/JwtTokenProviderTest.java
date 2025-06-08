package com.tuempresa.gestionpartidos.security.test;

import com.tuempresa.gestionpartidos.security.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource(properties = "jwt.secret=MiClaveSecretaBase64==")
public class JwtTokenProviderTest {
    @Test
    void testGenerarYValidarToken() {
        String secret = "bXlzZWNyZXRrZXlmb3Jqd3QxMjM0NTY3ODkwMTIzNDU2Nzg5MDEyMzQ1Njc4OTAxMjM0NTY3ODkwMTIzNDU2Nzg5MDE=";
        JwtTokenProvider jwt = new JwtTokenProvider(secret);
        jwt.setCustomExpirationMs(60000); // 1 minuto
        String token = jwt.generarToken("usuario@correo.com");
        assertNotNull(token);
        assertTrue(jwt.validarToken(token));
        assertEquals("usuario@correo.com", jwt.getUsernameFromToken(token));
    }

    @Test
    void testTokenInvalido() {
        String secret = "bXlzZWNyZXRrZXlmb3Jqd3QxMjM0NTY3ODkwMTIzNDU2Nzg5MDEyMzQ1Njc4OTAxMjM0NTY3ODkwMTIzNDU2Nzg5MDE=";
        JwtTokenProvider jwt = new JwtTokenProvider(secret);
        jwt.setCustomExpirationMs(60000); // 1 minuto
        assertFalse(jwt.validarToken("token-falso"));
    }
}
