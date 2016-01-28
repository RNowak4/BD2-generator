package encje;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Rezerwacja")
public class Rezerwacja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdRezerwacji")
    private int id;

    @Basic
    @Column(name = "Rabat")
    private int rabat;

    @ManyToOne
    @JoinColumn(name = "IdKlienta")
    private Klient klient;

    @ManyToOne
    @JoinColumn(name = "IdKategoriiPojazdu")
    private KategoriaPojazdu kategoriaPojazdu;

    @Basic
    @Column(name = "MiejsceOdbioru", length = 64)
    private String miejsceOdbioru;

    @Basic
    @Column(name = "SposobDostarczeniaRezerwacji", length = 64)
    private String sposobDostarczeniaRezerwacji;

    @Basic
    @Column(name = "Potwierdzenierezerwacji")
    private boolean potwierdzenieRezerwacji;

    @Basic
    @Column(name = "DataWypozyczenia")
    private Date dataWypozyczenia;

    @Basic
    @Column(name = "DataOddania")
    private Date dataOddania;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRabat() {
        return rabat;
    }

    public void setRabat(int rabat) {
        this.rabat = rabat;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public KategoriaPojazdu getKategoriaPojazdu() {
        return kategoriaPojazdu;
    }

    public void setKategoriaPojazdu(KategoriaPojazdu kategoriaPojazdu) {
        this.kategoriaPojazdu = kategoriaPojazdu;
    }

    public String getMiejsceOdbioru() {
        return miejsceOdbioru;
    }

    public void setMiejsceOdbioru(String miejsceOdbioru) {
        this.miejsceOdbioru = miejsceOdbioru;
    }

    public String getSposobDostarczeniaRezerwacji() {
        return sposobDostarczeniaRezerwacji;
    }

    public void setSposobDostarczeniaRezerwacji(String sposobDostarczeniaRezerwacji) {
        this.sposobDostarczeniaRezerwacji = sposobDostarczeniaRezerwacji;
    }

    public boolean isPotwierdzenieRezerwacji() {
        return potwierdzenieRezerwacji;
    }

    public void setPotwierdzenieRezerwacji(boolean potwierdzenieRezerwacji) {
        this.potwierdzenieRezerwacji = potwierdzenieRezerwacji;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rezerwacja that = (Rezerwacja) o;

        if (id != that.id) return false;
        if (rabat != that.rabat) return false;
        if (potwierdzenieRezerwacji != that.potwierdzenieRezerwacji) return false;
        if (klient != null ? !klient.equals(that.klient) : that.klient != null) return false;
        if (kategoriaPojazdu != null ? !kategoriaPojazdu.equals(that.kategoriaPojazdu) : that.kategoriaPojazdu != null)
            return false;
        if (miejsceOdbioru != null ? !miejsceOdbioru.equals(that.miejsceOdbioru) : that.miejsceOdbioru != null)
            return false;
        if (sposobDostarczeniaRezerwacji != null ? !sposobDostarczeniaRezerwacji.equals(that.sposobDostarczeniaRezerwacji) : that.sposobDostarczeniaRezerwacji != null)
            return false;
        if (dataWypozyczenia != null ? !dataWypozyczenia.equals(that.dataWypozyczenia) : that.dataWypozyczenia != null)
            return false;
        return dataOddania != null ? dataOddania.equals(that.dataOddania) : that.dataOddania == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + rabat;
        result = 31 * result + (klient != null ? klient.hashCode() : 0);
        result = 31 * result + (kategoriaPojazdu != null ? kategoriaPojazdu.hashCode() : 0);
        result = 31 * result + (miejsceOdbioru != null ? miejsceOdbioru.hashCode() : 0);
        result = 31 * result + (sposobDostarczeniaRezerwacji != null ? sposobDostarczeniaRezerwacji.hashCode() : 0);
        result = 31 * result + (potwierdzenieRezerwacji ? 1 : 0);
        result = 31 * result + (dataWypozyczenia != null ? dataWypozyczenia.hashCode() : 0);
        result = 31 * result + (dataOddania != null ? dataOddania.hashCode() : 0);
        return result;
    }
}
