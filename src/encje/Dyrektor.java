package encje;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idPracownika")
public class Dyrektor extends Pracownik {
    @OneToOne
    private Placowka placowka;

    public Placowka getPlacowka() {
        return placowka;
    }

    public void setPlacowka(Placowka placowka) {
        this.placowka = placowka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Dyrektor dyrektor = (Dyrektor) o;

        return placowka != null ? placowka.equals(dyrektor.placowka) : dyrektor.placowka == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (placowka != null ? placowka.hashCode() : 0);
        return result;
    }
}
