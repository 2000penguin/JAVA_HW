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
public class PhDStudent extends GraduateStudent
{
    private boolean Qualify;
    private boolean Dissertation;
    
    public PhDStudent(String name, String id, String major, String lab, String professor,
            boolean qualify, boolean dissertation)
    {
        super(name, id, major, lab, professor);
        
        this.Qualify = qualify;
        this.Dissertation = dissertation;
    }
    
    public String getQualify()
    {
        String q = "";
        
        if (Qualify==true)
        {
            q = "Passed";
        }
        else
        {
            q = "Didn't pass.";
        }
        
        return q;
    }
    
    public String getDissertation()
    {
        String d = "";
        
        if (Dissertation==true)
        {
            d = "finished";
        }
        else
        {
            d = "unfinished";
        }
        
        return d;
    }
}
