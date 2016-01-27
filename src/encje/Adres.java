package encje;

import javax.persistence.*;

@Entity
@Table(name ="Adres")
public class Adres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAdresu")
    private Integer id;

    @Basic
    @Column(name = "Miasto")
    private String miasto;

    @Basic
    @Column(name = "Ulica")
    private String ulica;

    @Basic
    @Column(name = "NrDomu")
    private String nrDomu;

    @Basic
    @Column(name = "KodPocztowy")
    private String kodPocztowy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adres adres = (Adres) o;

        if (id != null ? !id.equals(adres.id) : adres.id != null) return false;
        if (miasto != null ? !miasto.equals(adres.miasto) : adres.miasto != null) return false;
        if (ulica != null ? !ulica.equals(adres.ulica) : adres.ulica != null) return false;
        if (nrDomu != null ? !nrDomu.equals(adres.nrDomu) : adres.nrDomu != null) return false;
        return kodPocztowy != null ? kodPocztowy.equals(adres.kodPocztowy) : adres.kodPocztowy == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (miasto != null ? miasto.hashCode() : 0);
        result = 31 * result + (ulica != null ? ulica.hashCode() : 0);
        result = 31 * result + (nrDomu != null ? nrDomu.hashCode() : 0);
        result = 31 * result + (kodPocztowy != null ? kodPocztowy.hashCode() : 0);
        return result;
    }
}
