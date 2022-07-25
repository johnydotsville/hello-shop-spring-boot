package johny.dotsville.hello.domain.entities.city;

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
@Table(name = "city", schema = "bl")
@Getter @Setter
public class City extends AbstractEntity {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "city_id_gen", sequenceName = "city_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_id_gen")
    private long id;

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("City { ")
                .append("name: ").append(name)
                .append(" }");
        return sb.toString();
    }
}
