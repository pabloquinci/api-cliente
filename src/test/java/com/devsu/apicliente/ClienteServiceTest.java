package com.devsu.apicliente;

import com.devsu.apicliente.dto.rabbit.ClienteDTO;
import com.devsu.apicliente.repository.ClienteRepository;
import com.devsu.apicliente.service.ClienteService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DataJpaTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ClienteServiceTest {

    ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    @BeforeAll
    public void setUp(){

    }

    @Test
    public void whenGetClientsIsOk(){

    }
}
