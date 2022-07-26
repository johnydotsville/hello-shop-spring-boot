package johny.dotsville.hello.domain.entities.goods.serialization;

import com.fasterxml.jackson.databind.module.SimpleModule;
import johny.dotsville.hello.domain.entities.goods.Goods;
import org.springframework.stereotype.Service;

@Service
public class GoodsJsonModule extends SimpleModule {
    public GoodsJsonModule() {
        this.addSerializer(Goods.class, new GoodsSerializer());
        this.addDeserializer(Goods.class, new GoodsDeserializer());
    }
}
