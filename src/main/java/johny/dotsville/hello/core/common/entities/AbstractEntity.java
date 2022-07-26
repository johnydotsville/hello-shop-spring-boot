package johny.dotsville.hello.core.common.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;


@MappedSuperclass
@Getter @Setter
public abstract class AbstractEntity {
    @Column(name = "last_update", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Generated(
            value = org.hibernate.annotations.GenerationTime.ALWAYS)
    private Calendar lastUpdate;

    @Column(name = "mark_deleted", insertable = false, updatable = true)
    @org.hibernate.annotations.Generated(
            value = org.hibernate.annotations.GenerationTime.INSERT)
    private boolean markDeleted;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        return true;
    }
}
