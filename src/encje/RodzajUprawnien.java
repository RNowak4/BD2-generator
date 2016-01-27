package encje;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RodzajUprawnien {
    private Integer id;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
