package hw6;

/**
 *
 * @author jenny
 */
public class IDChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ID check=new ID();
        check.readFile("input.txt");
        check.printResult();
        check.Write();
    }
    
}
