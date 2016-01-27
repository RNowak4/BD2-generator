package encje;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Magazyn extends Placowka {
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

        Magazyn magazyn = (Magazyn) o;

        return wypozyczalnia != null ? wypozyczalnia.equals(magazyn.wypozyczalnia) : magazyn.wypozyczalnia == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (wypozyczalnia != null ? wypozyczalnia.hashCode() : 0);
        return result;
    }
}
