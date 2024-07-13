package com.devsu.apicliente;

import com.devsu.apicliente.dto.ClientesResponseDTO;
import com.devsu.apicliente.model.Cliente;
import com.devsu.apicliente.repository.ClienteRepository;
import com.devsu.apicliente.service.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)

public class ClienteServiceTest {

    ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    static Cliente cliente;

    static List<Cliente> clientes= new ArrayList<>();
    @BeforeAll
    public static void setUp(){
        cliente= Cliente.builder()
                .estado("OK")
                .contrasenia("1234")
                .build();

        cliente.setDni(221344L);
        cliente.setDireccion("ckfkfg");
        cliente.setEdad(33);

        clientes.add(cliente);

    }


    @Test
    void getClientesTest(){
        clienteService = new ClienteService(clienteRepository);

        lenient().when(clienteRepository.findAll()).thenReturn((clientes));

        Optional<ClientesResponseDTO>result= clienteService.getClientes();

        Assertions.assertEquals(true,result.isPresent());
    }
}
