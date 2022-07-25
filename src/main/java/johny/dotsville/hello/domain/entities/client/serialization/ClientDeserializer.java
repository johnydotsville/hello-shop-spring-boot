package johny.dotsville.hello.domain.entities.client.serialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import johny.dotsville.hello.domain.entities.client.Client;

import java.io.IOException;

public class ClientDeserializer extends JsonDeserializer<Client> {

    @Override
    public Client deserialize(JsonParser parser, DeserializationContext deserializationContext)
            throws IOException, JacksonException {
        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        String name = node.get("name").asText();
        String card = node.get("card").asText();

        Client client = new Client();
        client.setName(name);
        client.setCard(card);

        return client;
    }
}
