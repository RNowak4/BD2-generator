package encje;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Placowka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPlacowki")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "idPracownika")
    private Pracownik pracownik;

    @ManyToOne
    @JoinColumn(name = "idAdresu")
    private Adres adres;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
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

        Placowka placowka = (Placowka) o;

        if (id != null ? !id.equals(placowka.id) : placowka.id != null) return false;
        if (pracownik != null ? !pracownik.equals(placowka.pracownik) : placowka.pracownik != null) return false;
        return adres != null ? adres.equals(placowka.adres) : placowka.adres == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pracownik != null ? pracownik.hashCode() : 0);
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        return result;
    }
}
