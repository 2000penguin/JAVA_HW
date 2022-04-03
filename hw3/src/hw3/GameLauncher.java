package hw3;

import java.util.Scanner;

/**
 *
 * @author jenny
 */
public class GameLauncher {

   
    public static void main(String[] args) 
    {
       char more;
       
       try
       {
           do
           {
               Guess guess=new Guess();
               guess.Begin();
               guess.Set();
               guess.Play();
               
               Scanner input=new Scanner(System.in);
               System.out.println("**********再玩一次（Y/N）? :**********");
               more=input.next().charAt(0);
           }while(more=='Y'||more=='y');
           
           System.out.println("下次再見！拜拜~");
       }
        catch(Exception e)
        {
            System.out.println("輸入錯誤！拜拜~");
        }
    }
    
}
