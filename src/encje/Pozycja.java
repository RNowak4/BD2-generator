package encje;

import javax.persistence.*;

@Entity
@Table(name = "Pozycja")
public class Pozycja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdPozycji")
    private int id;

    @Basic
    @Column(name = "Liczba")
    private int liczba;

    @ManyToOne
    @JoinColumn(name = "Zamowienie_IdZamowienia")
    private Zamowienie zamowienie;

    @ManyToOne
    @JoinColumn(name = "Material_IdMaterialu")
    private Material material;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLiczba() {
        return liczba;
    }

    public void setLiczba(int liczba) {
        this.liczba = liczba;
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pozycja pozycja = (Pozycja) o;

        if (id != pozycja.id) return false;
        if (liczba != pozycja.liczba) return false;
        if (zamowienie != null ? !zamowienie.equals(pozycja.zamowienie) : pozycja.zamowienie != null) return false;
        return !(material != null ? !material.equals(pozycja.material) : pozycja.material != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + liczba;
        result = 31 * result + (zamowienie != null ? zamowienie.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        return result;
    }
}
