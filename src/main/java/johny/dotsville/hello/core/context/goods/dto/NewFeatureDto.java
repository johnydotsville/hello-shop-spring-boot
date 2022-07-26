package johny.dotsville.hello.core.context.goods.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class NewFeatureDto {
    private long goodsId;
    private List<FeatureDtoPost> features;
}
