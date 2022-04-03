
/**
 *
 * @author jenny
 */
public class Person 
{
    private String Name;
    
    public Person(String name)
    {
        this.Name = name;
    }
    
    public String getName()
    {
        return Name;
    }
    
    public String toString()
    {
        String a = "";
        
        System.out.printf("Name = %s.",getName());
        System.out.println("\n");
        
        return a;
    }
}
