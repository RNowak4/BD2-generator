package encje;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Klient {
    @Id
    private Integer id;

    @ManyToOne
    private Adres adres;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Klient klient = (Klient) o;

        if (id != null ? !id.equals(klient.id) : klient.id != null) return false;
        return adres != null ? adres.equals(klient.adres) : klient.adres == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        return result;
    }
}
