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
public class Student 
{
    private String Name;
    private String ID;
    private String Major;
    
    public Student(String name, String id, String major)
    {
        this.Name = name;
        this.ID = id;
        this.Major = major;
    }
    
    public String getName()
    {
        return Name;
    }
    
    public String getID()
    {
        return ID;
    }
    
    public String getMajor()
    {
        return Major;
    }
}
