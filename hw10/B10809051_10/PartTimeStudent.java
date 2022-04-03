/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw10;

/**
 *
 * @author jenny
 */
public class PartTimeStudent extends UndergraduateStudent
{
    private String Company;
    private String Position;
    
    public PartTimeStudent(String name, String id, String major, String grade, String classes,
            String company, String position)
    {
        super(name, id, major, grade, classes);
        
        this.Company = company;
        this.Position = position;
    }
    
    public String getCompany()
    {
        return Company;
    }
    
    public String getPosition()
    {
        return Position;
    }
}
