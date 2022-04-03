package hw2;
import java.util.Scanner;

/**
 *
 * @author jenny
 */
public class AccountTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String input;
        Scanner scanner=new Scanner(System.in);
        int OK=0;
        Account account=new Account();
        try
        {
            do{
            System.out.println("***Main Menu***");
            System.out.println("1) 開戶");
            System.out.println("2) 存款");
            System.out.println("3) 提款");
            System.out.println("4) 餘額查詢");
            System.out.println("0) Exit");
            System.out.println("Please enter the number in [1,2,3,4,0] :");
            input=scanner.next();
            int num=Integer.parseInt(input);
            switch(num){
                case 1:
                    try
                    {
                        if(OK==1)
                        {
                            System.out.println("已開過戶！\n");
                        }
                        else
                        {
                            System.out.println("請輸入開戶金額：");
                            input=scanner.next();
                            double open=Integer.parseInt(input);
                            
                            if(open>=1000)
                            {
                                account.setAccount(open);
                                System.out.printf("開戶成功！存入$%.2f\n",
                                        account.getAccount());
                                OK=1;
                            }
                            else if(open<1000)
                            {
                                System.out.println("開戶金額不足！\n");
                            }
                            else
                            {
                                System.out.println("輸入錯誤\n");
                            }
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("開戶失敗！請輸入金額！\n");
                    }
                    
                    break;
                    
                case 2:
                    if(OK==1)
                    {
                        System.out.println("請輸入存款金額：");
                        try
                        {
                            input=scanner.next();
                            double save=Integer.parseInt(input);
                            if(save>0)
                            {
                                account.Save(save);
                            }
                            else
                            {
                                System.out.println("輸入錯誤！\n");
                            }
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("輸入錯誤！\n");
                        }
                    }
                    else
                    {
                        System.out.println("尚未開戶！\n");
                    }
                    break;
                    
                case 3:
                     if(OK==1)
                    {
                        System.out.println("請輸入提款金額：");
                        try
                        {
                            input=scanner.next();
                            double take=Integer.parseInt(input);
                            if(take>0)
                            {
                                account.Take(take);
                            }
                            else
                            {
                                System.out.println("輸入錯誤！\n");
                            }
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("輸入錯誤！\n");
                        }
                    }
                    else
                    {
                        System.out.println("尚未開戶！\n");
                    }
                    break;
                    
                case 4:
                     if(OK==1)
                    {                        
                        System.out.printf("目前餘額：$%.2f\n",
                                    account.getAccount());
                    }
                    else
                    {
                        System.out.println("尚未開戶！\n");
                    }
                    break;
            }
        }while(!input.equals("0"));
        }
        catch(NumberFormatException e)
        {
            System.out.println("輸入錯誤！\n");
        }
        
    }
    
}
