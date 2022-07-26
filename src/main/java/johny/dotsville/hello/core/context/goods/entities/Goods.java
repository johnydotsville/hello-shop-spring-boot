package johny.dotsville.hello.core.context.goods.entities;

import johny.dotsville.hello.core.context.common.AbstractEntity;
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
import java.util.HashSet;
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
}
