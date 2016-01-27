package encje;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idPlacowki")
public class Serwis extends Placowka {
    @ManyToOne
    @JoinColumn(name = "idWypozyczalni")
    Wypozyczalnia wypozyczalnia;

    public Wypozyczalnia getWypozyczalnia() {
        return wypozyczalnia;
    }

    public void setWypozyczalnia(Wypozyczalnia wypozyczalnia) {
        this.wypozyczalnia = wypozyczalnia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Serwis serwis = (Serwis) o;

        return wypozyczalnia != null ? wypozyczalnia.equals(serwis.wypozyczalnia) : serwis.wypozyczalnia == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (wypozyczalnia != null ? wypozyczalnia.hashCode() : 0);
        return result;
    }
}
