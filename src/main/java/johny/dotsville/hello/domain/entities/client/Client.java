package johny.dotsville.hello.domain.entities.client;

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
import java.sql.Date;

@Entity
@Table(name = "client", schema = "bl")
@Getter @Setter
public class Client extends AbstractEntity {
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @SequenceGenerator(name = "client_id_gen", sequenceName = "client_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "client_id_gen", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "card")
    private String card;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client { ")
                .append("name: ").append(name)
                .append("card: ").append(card)
                .append(" }");
        return sb.toString();
    }
}
