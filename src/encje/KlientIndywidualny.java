package encje;

import javax.persistence.*;

@Entity
@Table(name = "KlientIndywidualny")
@PrimaryKeyJoinColumn(name="idKlienta")
public class KlientIndywidualny extends Klient {
    @Basic
    @Column(name = "Imie")
    private String imie;

    @Basic
    @Column(name = "nazwisko")
    private String nazwisko;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        KlientIndywidualny that = (KlientIndywidualny) o;

        if (imie != null ? !imie.equals(that.imie) : that.imie != null) return false;
        return nazwisko != null ? nazwisko.equals(that.nazwisko) : that.nazwisko == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        return result;
    }
}
