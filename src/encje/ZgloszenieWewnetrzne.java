package encje;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="IdZgloszenia")
public class ZgloszenieWewnetrzne extends Zgloszenie {
}
