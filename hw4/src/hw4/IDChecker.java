package hw4;

import java.util.Scanner;

/**
 *
 * @author jenny
 */
public class IDChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int answer;
        int leave;
        String ID;
        
        do
        {
            System.out.printf("*******************************\n");
            System.out.printf("1. 驗證身份證字號\n");
            System.out.printf("0. 離開\n");
            System.out.printf("*******************************\n");
            System.out.print("請選擇：");
            Scanner input=new Scanner(System.in);
            
            try
            {
                answer=input.nextInt();
                switch (answer) 
                {
                    case 1:
                        System.out.print("請輸入身分證字號（開頭須為大寫字母）：");
                        Scanner inputID=new Scanner(System.in);
                        ID=inputID.next();
                        ID id=new ID();
                        id.Check(ID);
                        leave=0;
                        break;
                        
                    case 0:
                        leave=1;
                        break;
                        
                    default:
                        leave=0;
                        System.out.printf("輸入代碼有誤，請重新輸入！\n");
                        break;
                }
            }
            catch(Exception e)
            {
                leave=0;
                System.out.printf("輸入錯誤！\n");
            }
        }while(leave==0);
    }
    
}
