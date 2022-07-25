package johny.dotsville.hello.web.controllers;

import johny.dotsville.hello.domain.entities.client.Client;
import johny.dotsville.hello.domain.repos.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Optional;
import java.time.LocalDate;

@RestController
public class EveryController {
    private ClientRepository clientRepo;

    public EveryController(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    @GetMapping("/client/{id}")
    public Client findClientById(@PathVariable(name = "id") long id) {
        Optional<Client> client = clientRepo.findById(id);

        return client.orElse(null);
    }

    @PostMapping("/client/new")
    public Client createNewClient(@RequestBody Client client) {
        Client newClient = new Client();
        newClient.setName("new " + client.getName());
        newClient.setCard("new " + client.getCard());
        newClient.setBirth(Date.valueOf(LocalDate.now()));

        return newClient;
    }
}
