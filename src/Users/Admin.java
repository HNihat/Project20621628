package Users;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Admin")
public class Admin {
    private String username;
    private String password;
    private String access;

    private static List<String> admin = new ArrayList<>(3);

    public Admin(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public static List<String> getAdmin() {
        return admin;
    }

    public static void setAdmin(List<String> admin) {
        Admin.admin = admin;
    }
}

