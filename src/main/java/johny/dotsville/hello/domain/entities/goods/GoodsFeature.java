package johny.dotsville.hello.domain.entities.goods;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "goods_feature", schema = "bl")
@Getter @Setter
public class GoodsFeature {
    @EmbeddedId
    private Id id = new Id();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id", insertable = false, updatable = false)
    private Goods goods;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id", insertable = false, updatable = false)
    private Feature feature;

    @Column(name = "value")
    private String value;

    private GoodsFeature() { }

    public GoodsFeature(Goods goods, Feature feature) {
        this.goods = goods;
        this.feature = feature;

        this.id.setFeatureId(feature.getId());
        this.id.setGoodsId(goods.getId());
    }

    @Embeddable
    @Getter @Setter
    public static class Id implements Serializable {
        @Column(name = "goods_id")
        private long goodsId;
        @Column(name = "feature_id")
        private long featureId;
    }
}
