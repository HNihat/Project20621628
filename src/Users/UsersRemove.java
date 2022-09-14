package Users;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Books.*;
import Exception.*;
public class UsersRemove {
    public void removeUser(String name) throws JAXBException, InvalidName, NotLoggedIn {
        if(!Login.isLogin()){
            throw new NotLoggedIn();
        }
        else{
            boolean status = true;
            for(int i = 0 ; i < Customer.getCustomer().size() ; i+=3){
                if(Customer.getCustomer().get(i).equals(name)){
                    status = false;
                    Customer.getCustomer().remove(i);
                    Customer.getCustomer().remove(i);
                    Customer.getCustomer().remove(i);

                    Login.setUsername("");
                    Login.setPassword("");
                    Login.setLogin(false);

                    List<Customer> customerList = new ArrayList<>();
                    for(int j = 0 ; j < Customer.getCustomer().size() ; j+=3){
                        customerList.add(new Customer(Customer.getCustomer().get(j),Customer.getCustomer().get(j+1),Customer.getCustomer().get(j+2)));
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

                        System.out.println("This account is removed: " + name);
                    }
                }
            }
            if(status){
                throw new InvalidName();
            }
        }


    }
}
