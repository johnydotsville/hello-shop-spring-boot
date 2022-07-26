package johny.dotsville.hello.core.context.goods.serialization;

import com.fasterxml.jackson.databind.module.SimpleModule;
import johny.dotsville.hello.core.context.goods.dto.GoodsDto;
import org.springframework.stereotype.Service;

@Service
public class GoodsDtoJsonModule extends SimpleModule {
    public GoodsDtoJsonModule() {
        this.addSerializer(GoodsDto.class, new GoodsDtoSerializer());
        this.addDeserializer(GoodsDto.class, new GoodsDtoDeserializer());
    }
}
