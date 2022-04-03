package hw7;

import java.util.Scanner;

/**
 *
 * @author jenny
 */
public class GameLauncher 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        
        do
        {
            Start();
            TicTacToe game = new TicTacToe();
            game.initializeBoard();
            game.Play();
        }while(More());
        
        
    }
    
    public static void Start()
    {
        System.out.println("********Game Start !*********");
    }
    
    public static boolean More()
    {
        char more;
        System.out.println("**********Game Over**********");
        Scanner input=new Scanner(System.in);
        System.out.println("**********Play again(Y/N) ? **********");
        more=input.next().charAt(0);
        
        if(more=='Y'||more=='y')
        {
            return true;
        }
        else
        {
            System.out.println("See you next time, bye bye ~");
            return false;
        }
    }
}
