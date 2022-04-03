
/**
 *
 * @author jenny
 */
public class PersonTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Person people[] = new Person[3];
        
        people[0] = new Staff("Alice", "BA", 22000);
        people[1] = new Student("Bob", "CS", "Master");
        people[2] = new TeachingAssistant("Alex", "MI", "PhD", "MI", 3000, "JAVA");
        
        for (int i = 0; i < people.length; i++)
        {
            people[i].toString();
        }
    }
    
}
