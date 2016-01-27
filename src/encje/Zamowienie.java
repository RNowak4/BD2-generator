package encje;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Zamowienie")
public class Zamowienie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdZamowienia")
    private int id;

    @ManyToOne
    @JoinColumn(name = "Magazyn_IdPlacowki")
    private Magazyn magazyn;

    @Basic
    @Column(name = "Data")
    private Date date;

    @Basic
    @Column(name = "NazwaDostawcy", length = 64)
    private String nazwaDostawcy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNazwaDostawcy() {
        return nazwaDostawcy;
    }

    public void setNazwaDostawcy(String nazwaDostawcy) {
        this.nazwaDostawcy = nazwaDostawcy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zamowienie that = (Zamowienie) o;

        if (id != that.id) return false;
        if (magazyn != null ? !magazyn.equals(that.magazyn) : that.magazyn != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return !(nazwaDostawcy != null ? !nazwaDostawcy.equals(that.nazwaDostawcy) : that.nazwaDostawcy != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (magazyn != null ? magazyn.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (nazwaDostawcy != null ? nazwaDostawcy.hashCode() : 0);
        return result;
    }
}
