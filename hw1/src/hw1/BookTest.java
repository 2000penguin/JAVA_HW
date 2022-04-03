package hw1;
import java.util.Scanner;

/**
 *
 * @author jenny
 */
public class BookTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Book book1=new Book();//create Book object
        
        book1.setbookName("HAPPY");//give name
        book1.setbookCode("001");//give code
        book1.setbookPrice(250);//give price
        
        System.out.printf("Book{bookPrice=$%.2f, bookName=%s, bookCode=%s}\n",
                book1.getbookPrice(),book1.getbookName(),book1.getbookCode());
        //print the information of book1
        
        
        Book book2=new Book();//create Book object
        String name;
        String code;
        double price;
        //creat Scanner to obtain input from command window
        Scanner input=new Scanner(System.in);
        
        System.out.print("Enter Second Book's Name\n");
        name=input.next();//obtain user input
        if(name!=null)
            book2.setbookName(name);//avoid error
        
        
        System.out.print("Enter Second Book's Code\n");
        code=input.next();//obtain user input
        if(code!=null)
            book2.setbookCode(code);//avoid error
        
        System.out.print("Enter Second Book's Price\n");
        price=input.nextDouble();//obtain user input
        if(price>0.0)
            book2.setbookPrice(price);//avoid error
        
        System.out.printf("Book{bookPrice=$%.2f, bookName=%s, bookCode=%s}\n",
                book2.getbookPrice(),book2.getbookName(),book2.getbookCode());
        //print the information of book1
    }
    
}
