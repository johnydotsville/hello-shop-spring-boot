package johny.dotsville.hello.domain.entities.client.serialization;

import com.fasterxml.jackson.databind.module.SimpleModule;
import johny.dotsville.hello.domain.entities.client.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientJsonModule extends SimpleModule {
    public ClientJsonModule() {
        this.addSerializer(Client.class, new ClientSerializer());
    }
}
