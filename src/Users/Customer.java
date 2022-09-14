package Users;



import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Customer")
public class Customer {
    private String username;
    private String password;
    private String access;

    private static List<String> customer = new ArrayList<>();

    public Customer(String username, String password, String access) {
        this.username = username;
        this.password = password;
        this.access = access;
    }

    public Customer(){}

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

    public static List<String> getCustomer() {
        return customer;
    }

    public static void setCustomer(List<String> customer) {
        Customer.customer = customer;
    }
}
