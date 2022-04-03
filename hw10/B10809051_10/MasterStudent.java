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
public class MasterStudent extends GraduateStudent
{
    private String System;
    private boolean Thesis;
    
    public MasterStudent(String name, String id, String major, String lab, String professor,
            String system, boolean thesis)
    {
        super(name, id, major, lab, professor);
        
        this.System = system;
        this.Thesis = thesis;
    }
    
    public String getSystem()
    {
        return System;
    }
    
    public String getThesis()
    {
        String t = "";
        
        if (Thesis==true)
        {
            t = "finished";
        }
        else
        {
            t = "unfinished";
        }
        
        return t;
    }
}
