package encje;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="idKlienta")
public class KlientInstytucjonalny extends Klient {
    @Basic
    @Column(name = "NIP")
    private String NIP;

    @ManyToOne
    @JoinColumn(name = "IdOpiekuna")
    private Szeregowy opiekun;

    @Basic
    @Column(name = "Nazwa")
    private String nazwa;

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public Szeregowy getOpiekun() {
        return opiekun;
    }

    public void setOpiekun(Szeregowy opiekun) {
        this.opiekun = opiekun;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        KlientInstytucjonalny that = (KlientInstytucjonalny) o;

        if (NIP != null ? !NIP.equals(that.NIP) : that.NIP != null) return false;
        if (opiekun != null ? !opiekun.equals(that.opiekun) : that.opiekun != null) return false;
        return nazwa != null ? nazwa.equals(that.nazwa) : that.nazwa == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (NIP != null ? NIP.hashCode() : 0);
        result = 31 * result + (opiekun != null ? opiekun.hashCode() : 0);
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        return result;
    }
}
