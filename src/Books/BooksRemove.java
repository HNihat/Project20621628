package Books;
import Exception.*;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooksRemove {
    public void removeBook(String title,int isbn) throws NotLoggedIn, JAXBException {
        if(!Login.isLogin()){
            throw new NotLoggedIn();
        }
        else{
            for(int i = 0 ; i < Book.getBooks().size() ; i+=8){
                if(Book.getBooks().get(i+1).equals(title) && Book.getBooks().get(i+6).equals(isbn)){
                    Book.getBooks().remove(i);
                    Book.getBooks().remove(i);
                    Book.getBooks().remove(i);
                    Book.getBooks().remove(i);
                    Book.getBooks().remove(i);
                    Book.getBooks().remove(i);
                    Book.getBooks().remove(i);
                    Book.getBooks().remove(i);

                    List<Book> bookList = new ArrayList<>();
                    for(int j = 0 ; j < Book.getBooks().size() ; j+=8){
                        bookList.add(new Book((String) Book.getBooks().get(j),(String) Book.getBooks().get(j+1),(String)Book.getBooks().get(j+2),(String)Book.getBooks().get(j+3),(String)Book.getBooks().get(j+4),
                                (int)Book.getBooks().get(j+5),(int)Book.getBooks().get(j+6),(double)Book.getBooks().get(j+7)));
                    }

                    ListBooks listBooks = new ListBooks();
                    listBooks.setBook(bookList);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print("File name: ");
                    String fileName = scanner.nextLine();
                    CommandLine commandLine = new CommandLine();
                    commandLine.commands("C:/xmlFiles/"+fileName);


                    commandLine.commands("C:/xmlFiles/"+fileName);
                    if(commandLine.isCloseOrSave()) {
                        JAXBContext jaxbContext = JAXBContext.newInstance(ListBooks.class);
                        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                        jaxbMarshaller.marshal(listBooks, new File("C:/xmlFiles/"+fileName));
                        System.out.println("Successfully removed...");
                    }
                }
            }

        }


    }
}

