package encje;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Kierownik")
@PrimaryKeyJoinColumn(name="idPracownika")
public class Kierownik extends Pracownik {
}
