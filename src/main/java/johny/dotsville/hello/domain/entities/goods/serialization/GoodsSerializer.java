package johny.dotsville.hello.domain.entities.goods.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import johny.dotsville.hello.domain.entities.goods.Goods;
import johny.dotsville.hello.domain.entities.goods.GoodsFeature;

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

        // Создание поля-массива объектов
        generator.writeArrayFieldStart("features");
        for (GoodsFeature gf : goods.getGoodsFeature()) {
            generator.writeStartObject();
            generator.writeStringField(gf.getFeature().getName(), gf.getValue());
            generator.writeEndObject();
        }
        generator.writeEndArray();


        generator.writeEndObject();
    }
}