package johny.dotsville.hello.core.context.goods.entities;

import johny.dotsville.hello.core.common.entities.AbstractEntity;
import johny.dotsville.hello.core.context.goods.dto.FeatureDtoGet;
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
    private Set<GoodsFeature> goodsFeature = new HashSet<>();

    @Column(name = "custom_attributes")
    // TODO: поискать, возможно ли из БД извлекать в словарь и обратно из словаря сохранять как строку
    private String customAttributes;

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

    public GoodsDto toDto() {
        GoodsDto dto = new GoodsDto();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setDescription(this.description);
        dto.setCustomAttributes(this.customAttributes);

        List<FeatureDtoGet> features = new ArrayList<>(goodsFeature.size());
        for (GoodsFeature gf : goodsFeature) {
            FeatureDtoGet fdto = new FeatureDtoGet();
            fdto.setName(gf.getFeature().getName());
            fdto.setValue(gf.getValue());
        }
        dto.setFeatures(features);
        return dto;
    }
}
