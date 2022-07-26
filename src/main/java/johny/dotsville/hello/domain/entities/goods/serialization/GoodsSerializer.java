package johny.dotsville.hello.domain.entities.goods.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import johny.dotsville.hello.domain.entities.goods.Goods;

import java.io.IOException;

public class GoodsSerializer extends JsonSerializer<Goods> {
    @Override
    public void serialize(Goods goods, JsonGenerator generator, SerializerProvider serializerProvider)
            throws IOException {
        generator.writeStartObject();
        generator.writeNumberField("id", goods.getId());
        generator.writeStringField("name", goods.getName());
        generator.writeStringField("description", goods.getDescription());
        generator.writeStringField("customAttributes", goods.getCustomAttributes());
        generator.writeEndObject();
    }
}