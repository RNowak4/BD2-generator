package encje;

import javax.persistence.*;

@Entity
public class Samochod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IdSamochodu")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdMarki")
    private Marka marka;

    @Basic
    @Column(name = "Model")
    private String model;

    @Basic
    @Column(name = "Rok_Produkcji")
    private String rokProdukcji;

    @Basic
    @Column(name = "Przebieg")
    private String przebieg;

    @Basic
    @Column(name = "Kolor")
    private String kolor;

    @ManyToOne
    @JoinColumn(name = "IdWypozyczalni")
    private Wypozyczalnia wypozyczalnia;

    @ManyToOne
    @JoinColumn(name = "IdKategoriiPojazdu")
    private KategoriaPojazdu kategoriaPojazdu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(String rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public String getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(String przebieg) {
        this.przebieg = przebieg;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public Wypozyczalnia getWypozyczalnia() {
        return wypozyczalnia;
    }

    public void setWypozyczalnia(Wypozyczalnia wypozyczalnia) {
        this.wypozyczalnia = wypozyczalnia;
    }

    public KategoriaPojazdu getKategoriaPojazdu() {
        return kategoriaPojazdu;
    }

    public void setKategoriaPojazdu(KategoriaPojazdu kategoriaPojazdu) {
        this.kategoriaPojazdu = kategoriaPojazdu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Samochod samochod = (Samochod) o;

        if (id != null ? !id.equals(samochod.id) : samochod.id != null) return false;
        if (marka != null ? !marka.equals(samochod.marka) : samochod.marka != null) return false;
        if (model != null ? !model.equals(samochod.model) : samochod.model != null) return false;
        if (rokProdukcji != null ? !rokProdukcji.equals(samochod.rokProdukcji) : samochod.rokProdukcji != null)
            return false;
        if (przebieg != null ? !przebieg.equals(samochod.przebieg) : samochod.przebieg != null) return false;
        if (kolor != null ? !kolor.equals(samochod.kolor) : samochod.kolor != null) return false;
        if (wypozyczalnia != null ? !wypozyczalnia.equals(samochod.wypozyczalnia) : samochod.wypozyczalnia != null)
            return false;
        return kategoriaPojazdu != null ? kategoriaPojazdu.equals(samochod.kategoriaPojazdu) : samochod.kategoriaPojazdu == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (marka != null ? marka.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (rokProdukcji != null ? rokProdukcji.hashCode() : 0);
        result = 31 * result + (przebieg != null ? przebieg.hashCode() : 0);
        result = 31 * result + (kolor != null ? kolor.hashCode() : 0);
        result = 31 * result + (wypozyczalnia != null ? wypozyczalnia.hashCode() : 0);
        result = 31 * result + (kategoriaPojazdu != null ? kategoriaPojazdu.hashCode() : 0);
        return result;
    }
}
