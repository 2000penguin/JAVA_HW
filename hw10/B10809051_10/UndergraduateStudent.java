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
public class UndergraduateStudent extends Student
{
    private String Grade;
    private String Classes;
    
    public UndergraduateStudent(String name, String id, String major, String grade, String classes)
    {
        super(name, id, major);
        
        this.Grade = grade;
        this.Classes = classes;
    }
    
    public String getGrade()
    {
        return Grade;
    }
    
    public String getClasses()
    {
        return Classes;
    }
}
