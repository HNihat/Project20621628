package Books;
import Exception.*;
public class Logout {

    public void logout() throws NotLoggedIn {
        if(Login.getUsername().equals("") && Login.getPassword().equals("")){
            throw new NotLoggedIn();
        }
        else{
            Login.setUsername("");
            Login.setPassword("");
            System.out.println("Exiting...");
            Login.setLogin(false);
        }

    }
}