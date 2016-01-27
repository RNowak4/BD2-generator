package encje;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="IdZgloszenia")
public class ZgloszenieZewnetrzne extends Zgloszenie {
    @ManyToOne
    @JoinColumn(name = "IdKlienta")
    private Klient klient;

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ZgloszenieZewnetrzne that = (ZgloszenieZewnetrzne) o;

        return !(klient != null ? !klient.equals(that.klient) : that.klient != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (klient != null ? klient.hashCode() : 0);
        return result;
    }
}
