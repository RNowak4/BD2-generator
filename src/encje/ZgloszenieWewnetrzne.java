package encje;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ZgloszenieWewnetrzne")
@PrimaryKeyJoinColumn(name="IdZgloszenia")
public class ZgloszenieWewnetrzne extends Zgloszenie {
}
