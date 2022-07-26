package johny.dotsville.hello.core.context.goods.serialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import johny.dotsville.hello.core.context.goods.dto.GoodsDto;
import johny.dotsville.hello.core.utils.exceptions.TechException;

import java.io.IOException;

public class GoodsDtoDeserializer extends JsonDeserializer<GoodsDto> {
    @Override
    public GoodsDto deserialize(JsonParser parser, DeserializationContext deserializationContext)
            throws IOException, JacksonException {
        try {
            ObjectCodec codec = parser.getCodec();
            JsonNode node = codec.readTree(parser);

            String name = node.get("name").asText();
            String description = node.get("description").asText();
            String customAttributes = node.get("custom_attributes").asText();

            GoodsDto goods = new GoodsDto();
            goods.setName(name);
            goods.setDescription(description);
            goods.setCustomAttributes(customAttributes);

            return goods;
        } catch (Exception ex) {
            throw new TechException("Не удалось сформировать объект " + GoodsDto.class.getName());
        }
    }
}