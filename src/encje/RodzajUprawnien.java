package encje;

import javax.persistence.*;

@Entity
@Table(name = "RodzajUprawnien")
public class RodzajUprawnien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdMarki")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RodzajUprawnien that = (RodzajUprawnien) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
