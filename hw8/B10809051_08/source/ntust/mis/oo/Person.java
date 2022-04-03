/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntust.mis.oo;

/**
 *
 * @author jenny
 */
public class Person 
{
    private String name;
    private String phoneNum;
    private City city;
    
    public Person(String name, String phoneNum, City city)
    {
        this.name=name;
        this.phoneNum=phoneNum;
        this.city=city;
    }
    
    @Override
    public String toString()
    {
        String output = String.format("%s-%s-%s",name,phoneNum,city);
        return output;
    }
}
