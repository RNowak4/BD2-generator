package encje;

import javax.persistence.*;

@Entity
public class Zgloszenie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdZgloszenia")
    private Integer id;

    @Basic
    @Column(name = "Priorytet")
    private int priorytet;

    @ManyToOne
    @JoinColumn(name = "IdTypuZgloszenia")
    private TypZgloszenia typZgloszenia;

    @ManyToOne
    @JoinColumn(name = "IdSamochodu")
    private Samochod samochod;

    @Basic
    @Column(name = "OpisStanuSamochodu")
    private String opisStanuSamochodu;

    @Basic
    @Column(name = "ParametrySamochodu")
    private String parametrySamochodu;

    @Basic
    @Column(name = "CzyPoJezdzieProbnej")
    private boolean czyPoJezdzieProbnej;

    @Basic
    @Column(name = "StanCzystosci")
    private int stanCzystosci;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPriorytet() {
        return priorytet;
    }

    public void setPriorytet(int priorytet) {
        this.priorytet = priorytet;
    }

    public TypZgloszenia getTypZgloszenia() {
        return typZgloszenia;
    }

    public void setTypZgloszenia(TypZgloszenia typZgloszenia) {
        this.typZgloszenia = typZgloszenia;
    }

    public Samochod getSamochod() {
        return samochod;
    }

    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
    }

    public String getOpisStanuSamochodu() {
        return opisStanuSamochodu;
    }

    public void setOpisStanuSamochodu(String opisStanuSamochodu) {
        this.opisStanuSamochodu = opisStanuSamochodu;
    }

    public String getParametrySamochodu() {
        return parametrySamochodu;
    }

    public void setParametrySamochodu(String parametrySamochodu) {
        this.parametrySamochodu = parametrySamochodu;
    }

    public boolean isCzyPoJezdzieProbnej() {
        return czyPoJezdzieProbnej;
    }

    public void setCzyPoJezdzieProbnej(boolean czyPoJezdzieProbnej) {
        this.czyPoJezdzieProbnej = czyPoJezdzieProbnej;
    }

    public int getStanCzystosci() {
        return stanCzystosci;
    }

    public void setStanCzystosci(int stanCzystosci) {
        this.stanCzystosci = stanCzystosci;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zgloszenie that = (Zgloszenie) o;

        if (priorytet != that.priorytet) return false;
        if (czyPoJezdzieProbnej != that.czyPoJezdzieProbnej) return false;
        if (stanCzystosci != that.stanCzystosci) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (typZgloszenia != null ? !typZgloszenia.equals(that.typZgloszenia) : that.typZgloszenia != null)
            return false;
        if (samochod != null ? !samochod.equals(that.samochod) : that.samochod != null) return false;
        if (opisStanuSamochodu != null ? !opisStanuSamochodu.equals(that.opisStanuSamochodu) : that.opisStanuSamochodu != null)
            return false;
        return parametrySamochodu != null ? parametrySamochodu.equals(that.parametrySamochodu) : that.parametrySamochodu == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + priorytet;
        result = 31 * result + (typZgloszenia != null ? typZgloszenia.hashCode() : 0);
        result = 31 * result + (samochod != null ? samochod.hashCode() : 0);
        result = 31 * result + (opisStanuSamochodu != null ? opisStanuSamochodu.hashCode() : 0);
        result = 31 * result + (parametrySamochodu != null ? parametrySamochodu.hashCode() : 0);
        result = 31 * result + (czyPoJezdzieProbnej ? 1 : 0);
        result = 31 * result + stanCzystosci;
        return result;
    }
}
