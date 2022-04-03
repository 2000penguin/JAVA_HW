package homework;

import java.util.Scanner;

/**
 *
 * @author jenny
 */
public class TimeLengthTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int leave;
        int answer;
        
        String Stime;
        String Atime;
        int time;
        int adjust;
        TimeLength userTime=new TimeLength();
        Scanner scanner=new Scanner(System.in);
        
        do
        {
            showMenu();
            try
            {
                answer=scanner.nextInt();
                switch(answer)
                {
                    case 1:
                        System.out.print("Please enter a time (seconds or hh:mm:ss): ");
                        Stime = scanner.next();
                        if(Stime.matches("\\d+[:]\\d+[:]\\d+"))
                        {
                            System.out.println("Time: "+Stime+ "\n");
                            String[] units = Stime.split(":");
                            int hr=Integer.parseInt(units[0]);
                            int min=Integer.parseInt(units[1]);
                            int sec=Integer.parseInt(units[2]);
                            time=sec+ (min*60) + (hr*3600);
                            userTime.setTime(time);
                            
                            System.out.println(time);
                        }
                        else if(Stime.matches("\\d*"))
                        {
                            System.out.println("Time: "+Stime+ "\n");
                            time=Integer.parseInt(Stime);
                            userTime.setTime(time);
                        }
                        else
                        {
                            System.out.println("The time is wrong.");
                        }
                        
                        leave=0;
                        break;
                        
                    case 2:
                        System.out.print("Please enter a time (seconds or hh:mm:ss): ");
                        Atime = scanner.next();
                        adjust= userTime.strToTime(Atime);
                        userTime.adjustTime(adjust);
                        leave=0;
                        break;
                        
                    case 3:
                        userTime.showTime();
                        leave=0;
                        break;
                    
                    case 0:
                        leave=1;
                        break;
                        
                    default:
                        leave=0;
                        System.out.println("The number is wrong.\n");
                        break;
                }
            }
            catch(NumberFormatException e)
            {
                leave=0;
                System.out.println("The enter is wrong.\n");
            }
        }while(leave==0);
    }
    
    public static void showMenu()
    {
        System.out.println("\n***Convert Length of Time***");
        System.out.println("1) Set the length of time.");
        System.out.println("2) Adjust the length of time.");
        System.out.println("3) Show length of time in different unit.");
        System.out.println("0) Exit\n");
        System.out.print("Please enter the number in [1,2,3,0]: ");
    }
    
}
