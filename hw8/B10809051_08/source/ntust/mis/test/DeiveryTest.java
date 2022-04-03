/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntust.mis.test;

import ntust.mis.oo.*;
import java.util.*;

/**
 *
 * @author jenny
 */
public class DeiveryTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int ok = 0;
        
        String sName; // s = sender
        String sPhone;
        int sAddressNum;
        City sAddress = City.TAIPEI;
        
        String rName; // r = receiver
        String rPhone;
        int rAddressNum;
        City rAddress = City.TAIPEI;
        
        String gName; // g = good
        double gWeight;
        int gTypeNum;
        Type gType = Type.PERSONAL;
        
        String ans;
        Boolean more = false;
        double aWeight; // a = avaliable
        
        do
        {
            // sender part
            System.out.print("Please enter the sender's name: ");
            sName = input.next();
            
            System.out.print("Please enter the sender's phone: ");
            sPhone=input.next();
            
            do
            {
                System.out.println("Please enter the sender's address(Please Enter 1-5)");
                System.out.print("(1)Taipei (2)Taichung (3)Kaohsiung (4)Hsinchu (5)Hualien: ");
                String sNum = input.next();
                ok = 0;
                
                try
                {
                    sAddressNum = Integer.parseInt(sNum);
                    
                    switch(sAddressNum)
                    {
                        case 1:
                            sAddress = City.TAIPEI;
                            ok = 1;
                            break;
                            
                        case 2:
                            sAddress = City.TAICHUNG;
                            ok = 1;
                            break;
                            
                        case 3:
                            sAddress = City.KAOHSIUNG;
                            ok = 1;
                            break;
                            
                        case 4:
                            sAddress = City.HSINCHU;
                            ok = 1;
                            break;
                            
                        case 5:
                            sAddress = City.HUALIEN;
                            ok = 1;
                            break;
                            
                        default:
                            System.out.println("Please enter 1-5 !");
                            ok = 0;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Please enter the number 1-5 !");
                    ok = 0;
                }
            }while(ok==0);
            
            System.out.println("\n");
            Person sender = new Person(sName,sPhone,sAddress);
            
            //receiver part
            System.out.print("Please enter the receiver's name: ");
            rName = input.next();
            
            System.out.print("Please enter the receiver's phone: ");
            rPhone = input.next();
            
            do
            {
                System.out.println("Please enter the sender's address(Please Enter 1-5)");
                System.out.print("(1)Taipei (2)Taichung (3)Kaohsiung (4)Hsinchu (5)Hualien: ");
                String rNum = input.next();
                ok = 0;
                
                try
                {
                    rAddressNum = Integer.parseInt(rNum);
                    
                    switch(rAddressNum)
                    {
                        case 1:
                            rAddress = City.TAIPEI;
                            ok = 1;
                            break;
                            
                        case 2:
                            rAddress = City.TAICHUNG;
                            ok = 1;
                            break;
                            
                        case 3:
                            rAddress = City.KAOHSIUNG;
                            ok = 1;
                            break;
                            
                        case 4:
                            rAddress = City.HSINCHU;
                            ok = 1;
                            break;
                            
                        case 5:
                            rAddress = City.HUALIEN;
                            ok = 1;
                            break;
                            
                        default:
                            System.out.println("Please enter 1-5 !");
                            ok = 0;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Please enter the number 1-5 !");
                    ok = 0;
                }
            }while(ok==0);
            
            System.out.println("\n");
            Person receiver = new Person(rName,rPhone,rAddress);
            
            //good part (?)
            System.out.print("Please enter the good's name: ");
            gName = input.next();
            
            System.out.print("Please enter the good's Weight: ");
            gWeight = input.nextDouble();
            
            do
            {
                System.out.println("Please enter the good's Type(Please Enter 1-2)");
                System.out.print("(1)Bussiness (2)Personal: ");
                String gNum = input.next();
                ok = 0;
                
                try
                {
                    gTypeNum = Integer.parseInt(gNum);
                    
                    switch(gTypeNum)
                    {
                        case 1:
                            gType = Type.PERSONAL;
                            ok = 1;
                            break;
                            
                        case 2:
                            gType = Type.BUSSINESS;
                            ok = 1;
                            break;
                            
                        default:
                            System.out.println("Please enter 1-2 !");
                            ok = 0;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Please enter the number 1-2 !");
                    ok = 0;
                }
            }while(ok==0);
            
            System.out.println("\n");
            Goods goods = new Goods(gName,gWeight,gType);
            
            Delivery delivery = new Delivery(sender,receiver,goods);
            
            // about weight
            System.out.printf("Previous remaining weight = %.1f \n",delivery.getAvaliableWeight());
            delivery.send();
            System.out.printf("Remain weight left = %.1f \n",delivery.getAvaliableWeight());
            System.out.println("");
            aWeight = delivery.getAvaliableWeight();
            
            // show
            System.out.printf("Sender: %s\n",sender.toString());
            System.out.printf("Receiver: %s\n",receiver.toString());
            System.out.printf("Goods: %s\n",goods.toString());
            System.out.println("");
            
            if(aWeight == 0)
            {
                System.out.println("Out of avaliable weight, thanks for your using \n");
                System.out.println("Process finished with exit code 0");
                more = false;
            }
            else
            {
                System.out.print("Do you want to continue (y/n) ?  ");
                ans = input.next();
                System.out.println("");
                
                if(ans.equals("y") || ans.equals("Y"))
                {
                    more = true;
                }
                else if (ans.equals("n") || ans.equals("N"))
                {
                    more = false;
                }
                else
                {
                    more = false;
                }
            }
        }while(more);
    }
    
    
}
