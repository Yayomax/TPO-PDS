package com.tuempresa.gestionpartidos.security.test;

import com.tuempresa.gestionpartidos.security.JwtAuthenticationFilter;
import com.tuempresa.gestionpartidos.security.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.TestPropertySource;

import javax.servlet.FilterChain;
import java.util.Collections;

import static org.mockito.Mockito.*;

@TestPropertySource(properties = "jwt.secret=MiClaveSecretaBase64==")
class JwtAuthenticationFilterTest {
    private JwtAuthenticationFilter filter;
    private JwtTokenProvider jwtTokenProvider;
    private UserDetailsService userDetailsService;
    private FilterChain filterChain;

    @BeforeEach
    void setUp() {
        String secret = "bXlzZWNyZXRrZXlmb3Jqd3QxMjM0NTY3ODkwMTIzNDU2Nzg5MDEyMzQ1Njc4OTAxMjM0NTY3ODkwMTIzNDU2Nzg5MDE=";
        jwtTokenProvider = new JwtTokenProvider(secret);
        jwtTokenProvider.setCustomExpirationMs(60000); // 1 minuto
        userDetailsService = mock(UserDetailsService.class);
        UserDetails userDetails = new User("usuario@correo.com", "password", Collections.emptyList());
        when(userDetailsService.loadUserByUsername("usuario@correo.com")).thenReturn(userDetails);
        AuthenticationManager authManager = mock(AuthenticationManager.class);
        filter = new JwtAuthenticationFilter(jwtTokenProvider, authManager, userDetailsService);
        filterChain = mock(FilterChain.class);
    }

    @Test
    void testDoFilterInternal_tokenValido() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String token = jwtTokenProvider.generarToken("usuario@correo.com");
        request.addHeader("Authorization", "Bearer " + token);
        filter.doFilterInternal(request, response, filterChain);
        verify(filterChain, times(1)).doFilter(request, response);
    }
}
