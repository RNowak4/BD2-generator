package encje;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KontoKlienta {
    private String login;

    @Id
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
