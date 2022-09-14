package Users;
import Exception.*;
import Books.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersAdd {
    public void addUser(String name,String password) throws InvalidName, JAXBException, NotLoggedIn {
        boolean status = false;
        if(Customer.getCustomer().isEmpty()){
            status = false;
        }
        else{
            for(int i = 0 ; i < Customer.getCustomer().size() ; i+=3){
                if(Customer.getCustomer().get(i).equals(name)){
                    status = true;
                }
            }
        }


        if(status){
            throw new InvalidName();
        }
        else{
            Customer.getCustomer().add(name);
            Customer.getCustomer().add(password);
            Customer.getCustomer().add("customer");

            List<Customer> customerList = new ArrayList<>();
            for(int i = 0 ; i < Customer.getCustomer().size() ; i+=3){
                customerList.add(new Customer(Customer.getCustomer().get(i),Customer.getCustomer().get(i+1),Customer.getCustomer().get(i+2)));
            }

            ListUsers listUsers = new ListUsers();
            listUsers.setCustomerList(customerList);

            Scanner scanner = new Scanner(System.in);
            System.out.print("File name: ");
            String fileName = scanner.nextLine();
            CommandLine commandLine = new CommandLine();
            commandLine.commands("C:/xmlFiles/"+fileName);


            commandLine.commands("C:/xmlFiles/"+fileName);
            if(commandLine.isCloseOrSave()) {
                JAXBContext jaxbContext = JAXBContext.newInstance(ListUsers.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                jaxbMarshaller.marshal(listUsers, new File("C:/xmlFiles/"+fileName));

                System.out.println("Account has been created...");
                System.out.println("Your username is: " + name);
                System.out.println("Your password is: " + passwordChange(name));
            }
        }

    }
    private String passwordChange(String name){
        int length = name.length();
        String newName = "";
        for(int i = 0; i < length-1 ; i++){
            newName+="*";
        }


        return newName;
    }
}
