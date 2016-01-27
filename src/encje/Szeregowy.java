package encje;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idPracownika")
public class Szeregowy extends Pracownik {
}
