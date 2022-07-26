package johny.dotsville.hello.web.controllers;

import johny.dotsville.hello.core.context.client.entities.Client;
import johny.dotsville.hello.core.context.client.repo.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ClientController {
    private ClientRepository clientRepo;

    public ClientController(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    @GetMapping("/client/{id}")
    public Client findClientById(@PathVariable(name = "id") long id) {
        Optional<Client> client = clientRepo.findById(id);
        return client.orElse(null);
    }

    @PostMapping("/client/new")
    public Client createNewClient(@RequestBody Client client) {
        Client newClient = clientRepo.save(client);
        return newClient;
    }
}
