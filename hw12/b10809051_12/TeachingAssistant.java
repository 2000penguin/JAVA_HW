
/**
 *
 * @author jenny
 */
public class TeachingAssistant extends Student implements Work
{
    private String Department;
    private double Salary;
    private String Course;
    
    public TeachingAssistant(String name, String major, String degree,
            String department, double salary, String course)
    {
        super(name, major, degree);
        
        setDepartment(department);
        setSalary(salary);
        setCourse(course);
    }
    
    @Override
    public void setDepartment(String department)
    {
        this.Department = department;
    }
    
    @Override
    public void setSalary(double salary)
    {
        this.Salary = salary;
    }
    
    public void setCourse(String course)
    {
        this.Course = course;
    }
    
    @Override
    public String getDepartment()
    {
        return Department;
    }
    
    @Override
    public double getSalary()
    {
        return Salary;
    }
    
    public String getCourse()
    {
        return Course;
    }
    
    @Override
    public String toString()
    {
        String a = "";
        
        System.out.printf("Student name = %s,\nwho studies in %s,\nwhose degree is %s,\n"
                + "who works in %s,\nwhose course is %s,\nwhose salary is %s.",getName(), getMajor(), getDegree(),
                getDepartment(), getCourse(), getSalary());
        System.out.println("\n");
        
        return a;
    }
}
