
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author pclab
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String input;
        Scanner scanner=new Scanner(System.in);
        int OK=0;
        Player player = new Player();
        Monster evil = new Monster();
        evil.setMonster(loadMonster("monster.txt"));
        
        do
        {
            Menu();
            input=scanner.next();
            try
            {
                int num=Integer.parseInt(input);
                switch(num)
                {
                    case 1:
                        System.out.print("請輸入玩家名稱：");
                        String name=scanner.next();
                        player.setName(name);
                        System.out.println("設定完成！\n");
                        OK=1;
                        break;
                        
                    case 2:
                        if(OK==1)
                        {
                            System.out.println("***目前玩家資訊***");
                            System.out.println("名稱：" + player.getName());
                            System.out.println("生命值：" + player.getHp());
                            System.out.println("金幣：" + player.getCoin());
                            System.out.println("******************");
                        }
                        else
                        {
                            System.out.println("尚未設定玩家名稱。\n");
                        }
                        break;
                        
                    case 3:
                        if(OK==1)
                        {
                            evil.Show();
                            
                            evil.Fight(); //怪物被打
                            if(evil.getHp() < 0)
                            {
                                System.out.println("Victory! \n");
                                player.setCoin(100);
                                break;
                            }
                            
                            player.Fight(); //我們被打
                            if(player.getHp() < 0)
                            {
                                System.out.println("Defeat! \n");
                                System.exit(0);
                            }
                            
                            
                        }
                        else
                        {
                            System.out.println("尚未設定玩家名稱。\n");
                        }
                        break;
                        
                    case 4:
                        if(OK==1)
                        {
                            player.Buy();
                        }
                        else
                        {
                            System.out.println("尚未設定玩家名稱。\n");
                        }
                        break;
                        
                    default:
                        if(num!=0)
                        {
                            System.out.println("請輸入0~4。\n");
                        }
                        break;
                        
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("輸入錯誤！\n");
            }
        }while(!input.equals("0"));
    }
    
    public static void Menu()
    {
        System.out.println("********LengendsGame********");
        System.out.println("1. 設定玩家資料");
        System.out.println("2. 顯示玩家資料");
        System.out.println("3. 開始攻擊");
        System.out.println("4. 商店");
        System.out.println("0. 離開");
        System.out.print("請輸入選項 [1,2,3,4,0]: ");
    }
    
    public static String monster;
    public static String loadMonster(String fileName)
    {
        int max;
        
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String str;
            
            String line=null; //讀取一行的資料
            StringBuilder data = new StringBuilder(); //讀取的資料
            while( (line = br.readLine()) != null)
            {
                data.append(line + "@");
            }
            
            br.close();
            fr.close();
            
            str=data.toString();
            String a[] = str.split("@");
            max=a.length;
            int i = (int) (Math.random() * (max - 0 + 1) + 0);
            monster = a[i];
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return monster;
    }
}
