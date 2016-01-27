package encje;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Wypozyczalnia")
@PrimaryKeyJoinColumn(name="idPlacowki")
public class Wypozyczalnia extends Placowka {
    @OneToOne
    // redundancja??
    private Pracownik dyrektor;

    public Pracownik getDyrektor() {
        return dyrektor;
    }

    public void setDyrektor(Pracownik dyrektor) {
        this.dyrektor = dyrektor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Wypozyczalnia that = (Wypozyczalnia) o;

        return dyrektor != null ? dyrektor.equals(that.dyrektor) : that.dyrektor == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (dyrektor != null ? dyrektor.hashCode() : 0);
        return result;
    }
}
