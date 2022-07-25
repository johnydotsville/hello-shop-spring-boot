package johny.dotsville.hello.domain.entities.client.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import johny.dotsville.hello.domain.entities.client.Client;

import java.io.IOException;

public class ClientSerializer extends JsonSerializer<Client> {
    @Override
    public void serialize(Client client, JsonGenerator generator, SerializerProvider serializerProvider)
            throws IOException {
        generator.writeStartObject();
        generator.writeNumberField("id", client.getId());
        generator.writeStringField("name", client.getName());
        generator.writeStringField("card", client.getCard());
        generator.writeStringField("birth", client.getBirth().toString());
        generator.writeEndObject();
    }
}
