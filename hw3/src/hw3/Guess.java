package hw3;

import java.util.Scanner;

/**
 *
 * @author jenny
 */
public class Guess 
{
    private int max;
    private int mini;
    private int limit;
    private int num;
    private int play;
    private int times=0;
    private int[] guess;
   
    public void Begin()
    {
        System.out.println("**********猜數字遊戲**********");
        
        int miniOK;
        do
        {
            try
            {
                Scanner input=new Scanner(System.in); 
                System.out.print("猜數字範圍最小值：");
                 mini=input.nextInt();
                 miniOK=1;
            }
            catch(Exception e)
            {
                System.out.print("請輸入數字！\n");
                miniOK=0;
            }
        }while(miniOK==0);
        
        int maxOK;
        do
        {
            try
            {
                Scanner input=new Scanner(System.in);
                System.out.print("猜數字範圍最大值：");
                max=input.nextInt();
                if(max>mini)
                {
                    maxOK=1;
                }
                else
                {
                    System.out.print("最大值應大於最小值！\n");
                    maxOK=0;
                }
            }
            catch(Exception e)
            {
                System.out.print("請輸入數字！\n");
                maxOK=0;
            }
        }while(maxOK==0);
        
        int limitOK;
        do
        {
            try
            {
                Scanner input=new Scanner(System.in);
                System.out.print("猜數字次數限制：");
                limit=input.nextInt();
                if(limit>=1)
                {
                    limitOK=1;
                    guess=new int [limit];
                }
                else
                {
                    System.out.print("次數限制需大於1(含)！\n");
                    limitOK=0;
                }
            }
            catch(Exception e)
            {
                System.out.print("請輸入大於等於1的數字！\n");
                limitOK=0;
            }
        }while(limitOK==0);
    }
    
    public void Set()
    {
        num=(int)(Math.random()*(max-mini+1)+mini);
        System.out.println("**********遊戲開始**********");
    }
    
    public void Play()
    {
        for(int i=0; i< limit; i++)
        {
            System.out.println("數字範圍："+mini+" ~ "+max);
            
            Scanner input=new Scanner(System.in);
            System.out.print("您猜的數字：");
            times+=1;
            play=input.nextInt();
            guess [i]=play;
            
            if(play==num)
            {
                System.out.println("恭喜您猜對了！");
                break;
            }
            else if(play>=mini && play<num)
            {
                mini=play;
                System.out.println("猜錯了！您猜的數字比答案小！");
            }
            else if(play<=max && play>num)
            {
                max=play;
                System.out.println("猜錯了！您猜的數字比答案大！");
            }
            else
            {
                System.out.println("猜錯了！數字不在範圍內！");
            }
            
        }
        
        System.out.println("**********遊戲結束**********");
        
        for(int j=0;j<=(times-1);j++)
        {
            System.out.print("第"+(j+1)+"猜："+guess[j]+"\n");
        }
        
        System.out.println("---------------------------");
        System.out.println("猜數字次數限制："+limit+"次");
        System.out.println("您猜的次數："+times+"次");
        System.out.println("正確數字："+num);
    }
    
}
