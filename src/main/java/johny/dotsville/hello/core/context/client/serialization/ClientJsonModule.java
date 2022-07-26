package johny.dotsville.hello.core.context.client.serialization;

import com.fasterxml.jackson.databind.module.SimpleModule;
import johny.dotsville.hello.core.context.client.entities.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientJsonModule extends SimpleModule {
    public ClientJsonModule() {
        this.addSerializer(Client.class, new ClientSerializer());
        this.addDeserializer(Client.class, new ClientDeserializer());
    }
}
