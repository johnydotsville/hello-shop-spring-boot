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
import java.util.Objects;

@Entity
@Table(name = "feature", schema = "bl")
@Getter @Setter
public class Feature extends AbstractEntity {
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @SequenceGenerator(name = "feature_id_gen", sequenceName = "feature_id_seq", schema = "bl", allocationSize = 1)
    @GeneratedValue(generator = "feature_id_gen", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name")
    private String name;

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        Feature feature = (Feature) obj;
        return Objects.equals(id, feature.id);
    }
}
