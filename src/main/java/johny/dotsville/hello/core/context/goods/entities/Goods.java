package johny.dotsville.hello.core.context.goods.entities;

import johny.dotsville.hello.core.common.entities.AbstractEntity;
import johny.dotsville.hello.core.context.goods.dto.FeatureValueDto;
import johny.dotsville.hello.core.context.goods.dto.GoodsDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "goods", schema = "bl")
@Getter @Setter
public class Goods extends AbstractEntity {
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @SequenceGenerator(name = "goods_id_gen", sequenceName = "goods_id_seq", schema = "bl", allocationSize = 1)
    @GeneratedValue(generator = "goods_id_gen", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "goods", fetch = FetchType.LAZY)
    private Set<GoodsFeature> goodsFeatures = new HashSet<>();

    @Column(name = "custom_attributes")
    // TODO: поискать, возможно ли из БД извлекать в словарь и обратно из словаря сохранять как строку
    private String customAttributes;

//    public long getId() {
//        return this.id;
//    }
//    public String getName() {
//        return this.name;
//    }
//    public String getDescription() {
//        return this.description;
//    }
//    public String getCustomAttributes() {
//        return this.customAttributes;
//    }
//    public Set<GoodsFeature> getGoodsFeature() {
//        return this.goodsFeatures;
//    }
    public List<FeatureValueDto> getFeatures() {
        var features = new ArrayList<FeatureValueDto>(goodsFeatures.size());
        for (GoodsFeature gf: goodsFeatures) {
            var feature = new FeatureValueDto();
            feature.setName(gf.getFeature().getName());
            feature.setValue(gf.getValue());
            features.add(feature);
        }
        return features;
    }
//    public void addOrUpdateFeatures(List<NewFeatureForGoodsDto.FeatureDto> features) {
//        for (NewFeatureForGoodsDto.FeatureDto feature : features) {
//            Optional<GoodsFeature> gf = goodsFeatures.stream()
//                    .filter(x -> x.getFeatureId() == feature.getId())
//                    .findFirst();
//            if (gf.isPresent()) {
//                gf.get().setValue(feature.getValue());
//            }
//        }
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, customAttributes);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        Goods goods = (Goods) obj;
        return Objects.equals(id, goods.id);
    }

    public static GoodsDto toDto(Goods goods) {
        GoodsDto dto = new GoodsDto();
        dto.setId(goods.id);
        dto.setName(goods.name);
        dto.setDescription(goods.description);
        dto.setCustomAttributes(goods.customAttributes);
        dto.setFeatures(goods.getFeatures());
        return dto;
    }

//    public static Goods fromDto(GoodsDto dto) {
//        throw new NotImplementedException("Создание Goods из Dto еще не сделано");
//    }
}
