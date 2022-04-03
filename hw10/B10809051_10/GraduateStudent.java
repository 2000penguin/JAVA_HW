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
public class GraduateStudent extends Student
{
    private String Lab;
    private String Professor;
    
    public GraduateStudent(String name, String id, String major, String lab, String professor)
    {
        super(name, id, major);
        
        this.Lab = lab;
        this.Professor = professor;
    }
    
    public String getLab()
    {
        return Lab;
    }
    
    public String getProfessor()
    {
        return Professor;
    }
}
