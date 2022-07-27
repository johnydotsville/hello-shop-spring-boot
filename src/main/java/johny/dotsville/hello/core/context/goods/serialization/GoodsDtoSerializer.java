package johny.dotsville.hello.core.context.goods.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import johny.dotsville.hello.core.context.goods.dto.FeatureValueDto;
import johny.dotsville.hello.core.context.goods.dto.GoodsDto;

import java.io.IOException;

public class GoodsDtoSerializer extends JsonSerializer<GoodsDto> {
    @Override
    public void serialize(GoodsDto goods, JsonGenerator generator, SerializerProvider serializerProvider)
            throws IOException {
        generator.writeStartObject();
        generator.writeNumberField("id", goods.getId());
        generator.writeStringField("name", goods.getName());
        generator.writeStringField("description", goods.getDescription());
        generator.writeStringField("customAttributes", goods.getCustomAttributes());

        // Создание поля-массива объектов
        generator.writeArrayFieldStart("features");
        for (FeatureValueDto feature : goods.getFeatures()) {
            generator.writeStartObject();
            generator.writeStringField(feature.getName(), feature.getValue());
            generator.writeEndObject();
        }
        generator.writeEndArray();

        generator.writeEndObject();
    }
}