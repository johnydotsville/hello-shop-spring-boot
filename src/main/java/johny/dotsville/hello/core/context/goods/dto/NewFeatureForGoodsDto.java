package johny.dotsville.hello.core.context.goods.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class NewFeatureForGoodsDto {
    private long goodsId;
    private List<FeatureDto> features;

    @Getter @Setter
    public static class FeatureDto {
        private long id;
        private String value;
    }
}
