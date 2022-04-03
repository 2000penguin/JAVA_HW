package hw6;

/**
 *
 * @author jenny
 */
public class List 
{
    private String id;
    private String result;
    private int correct; //等於1為正確
    
    public List(String id, String result, int correct)
    {
        this.id = id;
        this.result = result;
        this.correct=correct;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getResult()
    {
        return result;
    }
    
    public int getCorrect()
    {
        return correct;
    }
}
