package Books;

import Users.Customer;
import Users.Admin;
public class  Login {
    private static String username = "";
    private static String password = "";
    private static String access = "";
    private static boolean login = false;


    public void login(String name,String pass){
        boolean status = false;
        if(username.equals(name) && password.equals(pass)){
            System.out.println("You are already logged in...");
        }
        else{
            if(!isLogin()){
                for(int i = 0; i < Customer.getCustomer().size() ; i+=3){
                    if(Customer.getCustomer().get(i).equals(name) && Customer.getCustomer().get(i+1).equals(pass)){
                        System.out.println("Welcome <" + name + ">!");

                        setUsername(name);
                        setPassword(pass);
                        setAccess("customer");

                        setLogin(true);

                        status = true;
                    }
                    else{
                        System.out.println("Wrong username or password for customer...");
                    }
                }
                if(!status){
                    for(int i = 0 ; i < Admin.getAdmin().size() ; i+=3){
                        if(Admin.getAdmin().get(i).equals(name) && Admin.getAdmin().get(i+1).equals(pass)){
                            System.out.println("Welcome admin<" + name + ">!");
                            setUsername(name);
                            setPassword(pass);
                            setAccess("admin");

                            setLogin(true);
                            status = true;

                        }
                    }
                }
                if(!status){
                    System.out.println("Wrong username or password for customer...");
                }

            }
            else{
                System.out.println("Logout of your account...");
            }

        }


    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Login.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Login.password = password;
    }

    public static boolean isLogin() {
        return login;
    }

    public static void setLogin(boolean login) {
        Login.login = login;
    }

    public static String getAccess() {
        return access;
    }

    public static void setAccess(String access) {
        Login.access = access;
    }
}
