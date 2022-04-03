
/**
 *
 * @author jenny
 */
public class Student extends Person implements Study
{
    private String Major;
    private String Degree;
    
    public Student(String name, String major, String degree)
    {
        super(name);
        
        setMajor(major);
        setDegree(degree);
    }
    
    @Override
    public void setMajor(String major)
    {
        this.Major = major;
    }
    
    @Override
    public void setDegree(String degree)
    {
        this.Degree = degree;
    }
    
    @Override
    public String getMajor()
    {
        return Major;
    }
    
    @Override
    public String getDegree()
    {
        return Degree;
    }
    
    @Override
    public String toString()
    {
        String a = "";
        
        System.out.printf("Student name = %s,\nwho studies in %s,\nwhose degree is %s.",
                getName(), getMajor(), getDegree());
        System.out.println("\n");
        
        return a;
    }
}
