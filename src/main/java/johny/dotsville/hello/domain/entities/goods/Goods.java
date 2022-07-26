package johny.dotsville.hello.domain.entities.goods;

import johny.dotsville.hello.domain.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "goods", schema = "bl")
@Getter
@Setter
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

    @Column(name = "custom_attributes")
    private String customAttributes;
}
