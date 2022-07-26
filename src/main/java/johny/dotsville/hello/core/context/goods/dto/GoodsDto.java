package johny.dotsville.hello.core.context.goods.dto;

import johny.dotsville.hello.core.context.goods.entities.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class GoodsDto {
    private long id;
    private String name;
    private String description;
    private String customAttributes;
    private List<FeatureDtoGet> features;
}
