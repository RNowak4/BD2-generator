package encje;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Wypozyczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdWypozyczenia")
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdSamochodu")
    private Samochod samochod;

    @ManyToOne
    @JoinColumn(name = "IdKlienta")
    private Klient klient;

    @Basic
    @Column(name = "DataWypozyczenia")
    private Date dataWypozyczenia;

    @Basic
    @Column(name = "DataOddania")
    private Date dataOddania;

    @Basic
    @Column(name = "MiejsceWypozyczenia")
    private String miejsceWypozyczenia;

    @Basic
    @Column(name = "KwotaDoZaplaty")
    private float kwotaDoZaplaty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Samochod getSamochod() {
        return samochod;
    }

    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Date getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(Date dataWypozyczenia) {
        this.dataWypozyczenia = dataWypozyczenia;
    }

    public Date getDataOddania() {
        return dataOddania;
    }

    public void setDataOddania(Date dataOddania) {
        this.dataOddania = dataOddania;
    }

    public String getMiejsceWypozyczenia() {
        return miejsceWypozyczenia;
    }

    public void setMiejsceWypozyczenia(String miejsceWypozyczenia) {
        this.miejsceWypozyczenia = miejsceWypozyczenia;
    }

    public float getKwotaDoZaplaty() {
        return kwotaDoZaplaty;
    }

    public void setKwotaDoZaplaty(float kwotaDoZaplaty) {
        this.kwotaDoZaplaty = kwotaDoZaplaty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wypozyczenie that = (Wypozyczenie) o;

        if (id != that.id) return false;
        if (Float.compare(that.kwotaDoZaplaty, kwotaDoZaplaty) != 0) return false;
        if (samochod != null ? !samochod.equals(that.samochod) : that.samochod != null) return false;
        if (klient != null ? !klient.equals(that.klient) : that.klient != null) return false;
        if (dataWypozyczenia != null ? !dataWypozyczenia.equals(that.dataWypozyczenia) : that.dataWypozyczenia != null)
            return false;
        if (dataOddania != null ? !dataOddania.equals(that.dataOddania) : that.dataOddania != null) return false;
        return !(miejsceWypozyczenia != null ? !miejsceWypozyczenia.equals(that.miejsceWypozyczenia) : that.miejsceWypozyczenia != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (samochod != null ? samochod.hashCode() : 0);
        result = 31 * result + (klient != null ? klient.hashCode() : 0);
        result = 31 * result + (dataWypozyczenia != null ? dataWypozyczenia.hashCode() : 0);
        result = 31 * result + (dataOddania != null ? dataOddania.hashCode() : 0);
        result = 31 * result + (miejsceWypozyczenia != null ? miejsceWypozyczenia.hashCode() : 0);
        result = 31 * result + (kwotaDoZaplaty != +0.0f ? Float.floatToIntBits(kwotaDoZaplaty) : 0);
        return result;
    }
}
