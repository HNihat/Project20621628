package Books;
import Exception.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;

public class BooksAll {
    public void booksAll() throws JAXBException, NotLoggedIn {
        if(Login.getAccess().equals("admin") || !Login.isLogin()){
            throw new NotLoggedIn();
        }
        else{
            Scanner scanner = new Scanner(System.in);
            System.out.print("File name: ");
            String fileName = scanner.nextLine();
            CommandLine commandLine = new CommandLine();
            commandLine.commands("C:/xmlFiles/"+fileName);
            if(commandLine.isStatus()){
                JAXBContext jaxbContext = JAXBContext.newInstance(ListBooks.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                ListBooks listBooks = (ListBooks) jaxbUnmarshaller.unmarshal(new File("C:/xmlFiles/"+fileName));
                System.out.println("Books information:");
                for (Book book : listBooks.getBook()) {
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Genre: " + book.getGenre());
                    System.out.println("Isbn: " + book.getIsbn()+"\n");

                }
            }

        }

    }
}
