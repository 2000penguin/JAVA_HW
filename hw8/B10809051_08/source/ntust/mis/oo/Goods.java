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
public class Goods 
{
    private String name;
    private double weight;
    private Type type;
    
    public Goods(String name, double weight, Type type)
    {
        this.name=name;
        setWeight(weight);
        this.type=type;
    }
    
    private void setWeight(double weight)
    {
        if(weight>50)
        {
            this.weight=0;
            System.out.println("The good is too heavy, and it isn't able to delivery.");
        }
        else if(weight <= 50)
        {
            this.weight=weight;
        }
    }
    
    public double getWeight()
    {
        return weight;
    }
    
    @Override
    public String toString()
    {
        String output = String.format("%s-%.1f-%s",name,weight,type);
        return output;
    }
}
