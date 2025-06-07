package com.tuempresa.gestionpartidos.security.test;

import com.tuempresa.gestionpartidos.security.JwtAuthenticationFilter;
import com.tuempresa.gestionpartidos.security.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import javax.servlet.FilterChain;
import static org.mockito.Mockito.*;

class JwtAuthenticationFilterTest {
    private JwtAuthenticationFilter filter;
    private JwtTokenProvider jwtTokenProvider;
    private UserDetailsService userDetailsService;
    private FilterChain filterChain;

    @BeforeEach
    void setUp() {
        jwtTokenProvider = new JwtTokenProvider();
        userDetailsService = mock(UserDetailsService.class);
        filter = new JwtAuthenticationFilter();
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
