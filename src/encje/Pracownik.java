package encje;

import javax.persistence.*;

@Entity
@Table(name = "Pracownik")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pracownik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPracownika")
    private Integer id;

    @Basic
    @Column(name = "Imie", length = 16)
    private String imie;

    @Basic
    @Column(name = "Nazwisko", length = 16)
    private String nazwisko;

    @Basic
    @Column(name = "PESEL", length = 16)
    private String pesel;

    @ManyToOne
    @JoinColumn(name = "id_adresu")
    private Adres adres;

    public String getImie() {
        return imie;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

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

        Pracownik pracownik = (Pracownik) o;

        if (id != null ? !id.equals(pracownik.id) : pracownik.id != null) return false;
        if (imie != null ? !imie.equals(pracownik.imie) : pracownik.imie != null) return false;
        if (nazwisko != null ? !nazwisko.equals(pracownik.nazwisko) : pracownik.nazwisko != null) return false;
        if (pesel != null ? !pesel.equals(pracownik.pesel) : pracownik.pesel != null) return false;
        return adres != null ? adres.equals(pracownik.adres) : pracownik.adres == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        return result;
    }
}
