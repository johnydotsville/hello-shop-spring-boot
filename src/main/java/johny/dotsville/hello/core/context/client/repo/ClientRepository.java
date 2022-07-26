package johny.dotsville.hello.core.context.client.repo;

import johny.dotsville.hello.core.context.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByName(String name);
}