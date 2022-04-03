import java.util.Scanner;

/**
 *
 * @author pclab
 */
public class Player 
{
    private String name; //玩家名稱
    private int hp; //玩家生命值
    private int coin; //有的金幣
    
    String input;
    Scanner scanner=new Scanner(System.in);
    
    public void setName(String n) //整體初始化
    {
        name=n;
        hp=500;
        coin=100;
    }
    public String getName()
    {
        return name;
    }
    
    public void setHp(int h) //生命的加減
    {
        hp+=h;
    }
    public int getHp()
    {
        return hp;
    }
    
    public void setCoin(int m) //錢的加減
    {
        coin+=m;
    }
    public int getCoin()
    {
        return coin;
    }
    
    public void Buy()
    {
        System.out.print("請輸入購買紅水晶（補充10生命值）數量：");
        input=scanner.next();
        int buy = Integer.parseInt(input);
        int sum = buy*10;
        int ok;
        
        if(sum > coin)
        {
            System.out.println("金幣不足，請透過打怪來賺取更多金幣。\n");
        }
        else if(sum < 1)
        {
            System.out.println("取消購買紅水晶。\n");
        }
        else
        {
            do
            {
                System.out.print("確認以" +sum+ "金幣購買" +buy+ "份紅水晶（Y/N）？");
                input=scanner.next();
                String sure = input;
                
                if(sure.equals("Y") || sure.equals("y"))
                {
                    setHp(sum);
                    sum-= sum*2; //變負數
                    setCoin(sum);
                    System.out.println("購買完成！\n");
                    ok=1;
                }
                else if(sure.equals("N") || sure.equals("n"))
                {
                    System.out.println("已取消購買。\n");
                    ok=1;
                }
                else
                {
                    ok=0;
                }
            }while(ok==0);
        }
    }
    
    public void Fight()
    {
        int hit=(int) (Math.random() * (50 - 40 + 1) + 40);
        hit-= hit*2;
        setHp(hit);
        System.out.printf("您受到 %d 攻擊（生命值剩餘：%d）\n",hit,hp);
    }
}
