package encje;

import javax.persistence.*;

@Entity
@Table(name = "Marka")
public class Marka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdMarki")
    private Integer id;

    @Basic
    @Column(name = "Nazwa", length = 32)
    private String nazwa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Marka marka = (Marka) o;

        if (id != null ? !id.equals(marka.id) : marka.id != null) return false;
        return nazwa != null ? nazwa.equals(marka.nazwa) : marka.nazwa == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        return result;
    }
}
