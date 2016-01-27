package encje;

import javax.persistence.*;
import java.util.Date;

@Entity
public class KontoPracownika {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "login")
    private String login;

    @Basic
    @Column(name = "DataZmianyHasla")
    private Date dataZmianyHasla;

    @OneToOne
    @JoinColumn(name = "IdPracownika")
    private Pracownik pracownik;

    // TODO: 2016-01-27 Niby ma tu byc join, ale w dokumentacji nie ma takiej encji
    @Basic
    @Column(name = "IdUprawnien")
    private int idUprawnien;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDataZmianyHasla() {
        return dataZmianyHasla;
    }

    public void setDataZmianyHasla(Date dataZmianyHasla) {
        this.dataZmianyHasla = dataZmianyHasla;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public int getIdUprawnien() {
        return idUprawnien;
    }

    public void setIdUprawnien(int idUprawnien) {
        this.idUprawnien = idUprawnien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KontoPracownika that = (KontoPracownika) o;

        if (idUprawnien != that.idUprawnien) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (dataZmianyHasla != null ? !dataZmianyHasla.equals(that.dataZmianyHasla) : that.dataZmianyHasla != null)
            return false;
        return pracownik != null ? pracownik.equals(that.pracownik) : that.pracownik == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (dataZmianyHasla != null ? dataZmianyHasla.hashCode() : 0);
        result = 31 * result + (pracownik != null ? pracownik.hashCode() : 0);
        result = 31 * result + idUprawnien;
        return result;
    }
}
