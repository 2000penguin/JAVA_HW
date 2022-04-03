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
public class Delivery 
{
    private Person sender;
    private Person receiver;
    private Goods goods;
    private double aWeight; // a = avaliable
    
    private static final double MAX_WEIGHT = 100;
    private static double currentWeight = 0;
    
    public Delivery(Person sender, Person receiver, Goods goods)
    {
        this.sender = sender;
        this.receiver = receiver;
        this.goods = goods;
    }
    
    public double  getAvaliableWeight()
    {
        aWeight = MAX_WEIGHT-currentWeight;
        return aWeight;
    }
    
    public void send()
    {
        double goodWeight = goods.getWeight();
        
        if(goodWeight > aWeight)
        {
            this.currentWeight += 0;
        }
        else
        {
            this.currentWeight += goodWeight;
        }
    }
}
