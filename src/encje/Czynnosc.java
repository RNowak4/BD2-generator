package encje;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Czynnosc")
public class Czynnosc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCzynnosci")
    private Integer id;

    @Basic
    @Column(name = "Data")
    private Date date;

    @Basic
    @Column(name = "Opis", length = 256)
    private String description;

    @ManyToOne
    @JoinColumn(name = "idPracownika")
    private Pracownik pracownik;

    @ManyToOne
    @JoinColumn(name = "idZgloszenia")
    private Zgloszenie zgloszenie;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Zgloszenie getZgloszenie() {
        return zgloszenie;
    }

    public void setZgloszenie(Zgloszenie zgloszenie) {
        this.zgloszenie = zgloszenie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Czynnosc czynnosc = (Czynnosc) o;

        if (id != null ? !id.equals(czynnosc.id) : czynnosc.id != null) return false;
        if (date != null ? !date.equals(czynnosc.date) : czynnosc.date != null) return false;
        if (description != null ? !description.equals(czynnosc.description) : czynnosc.description != null)
            return false;
        if (pracownik != null ? !pracownik.equals(czynnosc.pracownik) : czynnosc.pracownik != null) return false;
        return zgloszenie != null ? zgloszenie.equals(czynnosc.zgloszenie) : czynnosc.zgloszenie == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pracownik != null ? pracownik.hashCode() : 0);
        result = 31 * result + (zgloszenie != null ? zgloszenie.hashCode() : 0);
        return result;
    }
}
