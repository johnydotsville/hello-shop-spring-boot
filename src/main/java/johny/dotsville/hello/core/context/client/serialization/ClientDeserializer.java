package johny.dotsville.hello.core.context.client.serialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import johny.dotsville.hello.core.context.client.entities.Client;
import johny.dotsville.hello.core.utils.exceptions.TechException;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class ClientDeserializer extends JsonDeserializer<Client> {
    @Override
    public Client deserialize(JsonParser parser, DeserializationContext deserializationContext)
            throws IOException, JacksonException {
        try {
            ObjectCodec codec = parser.getCodec();
            JsonNode node = codec.readTree(parser);

            String name = node.get("name").asText();
            String card = node.get("card").asText();

            String sBirth = node.get("birth").asText();
            Date birth = Date.valueOf(LocalDate.parse(sBirth));

            Client client = new Client();
            client.setName(name);
            client.setCard(card);
            client.setBirth(birth);

            return client;
        } catch (Exception ex) {
            throw new TechException("Не удалось сформировать объект " + Client.class.getName());
        }
    }
}
