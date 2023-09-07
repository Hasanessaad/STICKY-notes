package com.example.sticky;
import com.example.sticky.Controller.ClientController;
import com.example.sticky.Entity.Client;
import com.example.sticky.Repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ClientTest {
        @MockBean
        ClientRepository clientRepository;

        private final ClientController controller = new ClientController();
//        private final ClientController cont = new ClientController();

        @BeforeEach
        void injectData() {
            Optional<Client> client = Optional.of(new Client(1L, "william"));
            Long id = 1L;

            Mockito.when(clientRepository.findById(id)).thenReturn(client); // Move the parenthesis
        }

        @Test
        void testControllerClient() {
            var clientController = controller.getById(1L);
            Long id = clientController.getId().longValue(); // Change clientController.getById() to clientController.getId()
            System.out.println(id);
            List<Client> cur_client = new ArrayList<Client>();


//            var clientHabibi = clientRepository.findByName("habibi");
//            String name = clientHabibi.getName();
//            System.out.println(name);
//
//            // Add your assertions here
//            Assert.notNull(clientHabibi, "Client 'habibi' should not be null");
        }
    }
