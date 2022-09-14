package Books;
import Exception.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;

public class BookInfo {
    public void bookInfo(int isbn) throws JAXBException, InvalidData, NotLoggedIn {
        int length = 0;
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
                ListBooks books = (ListBooks) jaxbUnmarshaller.unmarshal(new File("C:/xmlFiles/"+fileName));
                for (Book book : books.getBook()) {
                    if (isbn == book.getIsbn()) {
                        System.out.println("Book information:");
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Genre: " + book.getGenre());
                        System.out.println("Isbn: " + book.getIsbn() + "\n");
                        length++;
                    }
                }
                if (length == 0) {
                    throw new InvalidData("Invalid isbn - "+isbn);
                }
            }

        }

    }
}
