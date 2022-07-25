package johny.dotsville.hello.domain.repos;

import johny.dotsville.hello.domain.entities.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByName(String name);
}