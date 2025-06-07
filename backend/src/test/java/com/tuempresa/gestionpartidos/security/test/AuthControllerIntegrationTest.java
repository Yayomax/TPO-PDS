package com.tuempresa.gestionpartidos.security.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuempresa.gestionpartidos.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testRegisterYLogin() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("Test");
        usuario.setEmail("test@correo.com");
        usuario.setPassword("123456");
        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"test@correo.com\",\"password\":\"123456\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
    }
}
