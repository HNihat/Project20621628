package Exception;


public class NotLoggedIn extends Exception{
    public NotLoggedIn(){
        super("You are not logged in...");
    }
}
