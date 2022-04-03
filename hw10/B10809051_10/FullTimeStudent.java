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
public class FullTimeStudent extends UndergraduateStudent
{
    private String Club;
    private String Role;
    
    public FullTimeStudent(String name, String id, String major, String grade, String classes,
            String club, String role)
    {
        super(name, id, major, grade, classes);
        
        this.Club = club;
        this.Role = role;
    }
    
    public String getClub()
    {
        return Club;
    }
    
    public String getRole()
    {
        return Role;
    }
}
