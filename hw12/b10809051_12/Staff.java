
/**
 *
 * @author jenny
 */
public class Staff extends Person implements Work
{
    private String Department;
    private double Salary;
    
    public Staff(String name, String department, double salary)
    {
        super(name);
        
        setDepartment(department);
        setSalary(salary);
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
    
    @Override
    public String toString()
    {
        String a = "";
        
        System.out.printf("Staff name = %s,\nwho works in %s, \nwhose salary is %s.",
                getName(), getDepartment(), getSalary());
        System.out.println("\n");
        
        return a;
    }
}
