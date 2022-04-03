package hw1;

/**
 *
 * @author jenny
 */
public class Book
{
    private String bookName;//stores the name
    private String bookCode;//stores the code
    private double bookPrice;//stores the price
    
    
    //method to set bookName
    public void setbookName(String Name)
    {
        this.bookName=Name;
    }//end method setbookName
    
    //return the book's name
    public String getbookName()
    {
        return bookName;
    }//end method getbookName
    
    
    //method to set bookCode
    public void setbookCode(String Code)
    {
        this.bookCode=Code;
    }//end method setbookCode
    
    //return the book's code
    public String getbookCode()
    {
        return bookCode;
    }//end method getbookCode
    
    
    //method to set bookPrice
    public void setbookPrice(double Price)
    {
        this.bookPrice=Price;
    }//end method setbookPrice
    
    //return the book's price
    public double getbookPrice()
    {
        return bookPrice;
    }//end method getbookPrice
}//end class Book
