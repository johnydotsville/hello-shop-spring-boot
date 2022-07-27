package johny.dotsville.hello.core.context.goods.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GoodsFeatureDto {
    private long goodsId;
    private long featureId;
    private String featureValue;
}
