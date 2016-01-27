package encje;

import javax.persistence.*;

@Entity
@Table(name = "Material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdMaterialu")
    private Integer id;

    @Basic
    @Column(name = "nazwa", length = 64)
    private String nazwa;

    @Basic
    @Column(name = "CzyDoOdbioru")
    private boolean czyDoOdbioru;

    @ManyToOne
    @JoinColumn(name = "IdPlacowki")
    private Placowka placowka;

    @ManyToOne
    @JoinColumn(name = "IdCzynnosci")
    private Czynnosc czynnosc;

    @ManyToOne
    @JoinColumn(name = "IdPracownika")
    private Szeregowy pracownik;

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

    public boolean isCzyDoOdbioru() {
        return czyDoOdbioru;
    }

    public void setCzyDoOdbioru(boolean czyDoOdbioru) {
        this.czyDoOdbioru = czyDoOdbioru;
    }

    public Placowka getPlacowka() {
        return placowka;
    }

    public void setPlacowka(Placowka placowka) {
        this.placowka = placowka;
    }

    public Czynnosc getCzynnosc() {
        return czynnosc;
    }

    public void setCzynnosc(Czynnosc czynnosc) {
        this.czynnosc = czynnosc;
    }

    public Szeregowy getPracownik() {
        return pracownik;
    }

    public void setPracownik(Szeregowy pracownik) {
        this.pracownik = pracownik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Material material = (Material) o;

        if (czyDoOdbioru != material.czyDoOdbioru) return false;
        if (id != null ? !id.equals(material.id) : material.id != null) return false;
        if (nazwa != null ? !nazwa.equals(material.nazwa) : material.nazwa != null) return false;
        if (placowka != null ? !placowka.equals(material.placowka) : material.placowka != null) return false;
        if (czynnosc != null ? !czynnosc.equals(material.czynnosc) : material.czynnosc != null) return false;
        return pracownik != null ? pracownik.equals(material.pracownik) : material.pracownik == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (czyDoOdbioru ? 1 : 0);
        result = 31 * result + (placowka != null ? placowka.hashCode() : 0);
        result = 31 * result + (czynnosc != null ? czynnosc.hashCode() : 0);
        result = 31 * result + (pracownik != null ? pracownik.hashCode() : 0);
        return result;
    }
}
