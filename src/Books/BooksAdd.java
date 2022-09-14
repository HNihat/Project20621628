package Books;
import Exception.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooksAdd {
    public void addBooks(String author,String title,String genre,String description,String keywords,int year,int isbn,double rating) {
        try{
            if(!Login.isLogin()){
                throw new NotLoggedIn();
            }
            else{
                Book.getBooks().add(author);
                Book.getBooks().add(title);
                Book.getBooks().add(genre);
                Book.getBooks().add(description);
                Book.getBooks().add(keywords);
                Book.getBooks().add(year);
                Book.getBooks().add(isbn);
                Book.getBooks().add(rating);

                List<Book> bookList = new ArrayList<>();
                for(int i = 0 ; i < Book.getBooks().size() ; i+=8){
                    bookList.add(new Book((String) Book.getBooks().get(i),(String) Book.getBooks().get(i+1),(String)Book.getBooks().get(i+2),(String)Book.getBooks().get(i+3),(String)Book.getBooks().get(i+4),
                            (int)Book.getBooks().get(i+5),(int)Book.getBooks().get(i+6),(double)Book.getBooks().get(i+7)));
                }

                ListBooks listBooks = new ListBooks();
                listBooks.setBook(bookList);

                Scanner scanner = new Scanner(System.in);
                System.out.print("File name: ");
                String fileName = scanner.nextLine();
                CommandLine commandLine = new CommandLine();
                commandLine.commands("C:/xmlFiles/"+fileName);


                commandLine.commands("C:/xmlFiles/"+fileName);
                if(commandLine.isCloseOrSave()){
                    JAXBContext jaxbContext = JAXBContext.newInstance(ListBooks.class);
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                    jaxbMarshaller.marshal(listBooks,new File("C:/xmlFiles/"+fileName));
                    System.out.println("Successfully added...");
                }

            }

        }
        catch (ClassCastException e){
            System.out.println(e);
        }
        catch (JAXBException e){
            System.out.println(e);
        } catch (NotLoggedIn notLoggedIn) {
            System.out.println(notLoggedIn);
        }catch (Exception e){
            System.out.println(e);
        }


    }
}
