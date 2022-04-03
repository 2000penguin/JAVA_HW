package hw4;

/**
 *
 * @author jenny
 */
public class ID 
{
    private final String alphabet="ABCDEFGHJKLMNPQRSTUVXYWZIO";
    private String sex;
    private final String[] place=
    {
        "台北市","台中市","基隆市","台南市","高雄市","台北縣",
        "宜蘭縣","桃園縣","新竹縣","苗栗縣","台中縣","南投縣",
        "彰化縣","雲林縣","嘉義縣","台南縣","高雄縣","屏東縣",
        "花蓮縣","台東縣","澎湖縣","陽明山管理局","金門縣","連江縣",
        "嘉義市","新竹市"
    };
    
    public void Check(String id)
    {
        try
        {
            if(id.length()==10) //檢查長度
            {
                char[] c=id.toCharArray(); //將身分證字號轉成字元陣列
                int[] ID=new int [c.length]; //運算用的整數陣列
                int sum; //加總用
                
                if(alphabet.indexOf(c[0])==-1) //檢查第一位是否為大寫字母
                {
                    System.out.printf("格式不符！第一位須為大寫字母！\n");
                }
                
                else
                {
                    if(c[1]=='1'||c[1]=='2') //檢查第二位數字
                    {
                        if(c[1]=='1')
                        {
                            sex="男姓朋友";
                        }
                        else
                        {
                            sex="女姓朋友";
                        }
                        
                        ID[0]=alphabet.indexOf(c[0])+10;
                        int first=ID[0];
                        sum=(first/10)+((first%10)*9);
                        
                        for(int i=1; i<10; i++)
                        {
                            ID[i]=(int)c[i]-48; //將後九碼轉成整數
                        }
                        for(int j=1; j<9; j++)
                        {
                            ID[j]*=(9-j);
                            sum+=ID[j]; //使用公式加總
                        }
                        sum+=ID[9];
                        if((sum%10)==0)
                        {
                            //印出哪裡人以及性別
                            System.out.printf("身份證字號正確！\n");
                            System.out.printf("是位出生在"+
                                    place[first-10]+"的"+sex+"呢！\n");
                        }
                        else
                        {
                            System.out.printf("身份證字號錯誤！\n");
                        }
                    }
                    else
                    {
                        System.out.printf("格式不符！第一位須為1或2！\n");
                    }
                }
            }
            else
            {
                System.out.printf("長度不符！長度須為10！\n");
            }
        }
        catch(Exception e)
        {
            System.out.printf("格式不符！\n");
        }
    }
    
}
