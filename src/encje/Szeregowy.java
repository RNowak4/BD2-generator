package encje;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Szeregowy")
@PrimaryKeyJoinColumn(name="idPracownika")
public class Szeregowy extends Pracownik {
}
