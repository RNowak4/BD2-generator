package encje;

import javax.persistence.*;

@Entity
@Table(name = "KontoKlienta")
public class KontoKlienta {
    @Id
    @Column(name = "Login", length = 64)
    private String login;

    @Basic
    @Column(name = "Haslo", length = 32)
    private String haslo;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KontoKlienta that = (KontoKlienta) o;

        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        return !(haslo != null ? !haslo.equals(that.haslo) : that.haslo != null);

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (haslo != null ? haslo.hashCode() : 0);
        return result;
    }
}
