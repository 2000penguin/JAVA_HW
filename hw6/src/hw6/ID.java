package hw6;

import java.io.*;

/**
 *
 * @author jenny
 */
public class ID 
{
    private String id;
    private String sex;
    private String result;
    private int correct; //等於1為正確
    
    private List[] ids;
    
    private final String alphabet="ABCDEFGHJKLMNPQRSTUVXYWZIO";
    private final String[] place=
    {
        "台北市","台中市","基隆市","台南市","高雄市","台北縣",
        "宜蘭縣","桃園縣","新竹縣","苗栗縣","台中縣","南投縣",
        "彰化縣","雲林縣","嘉義縣","台南縣","高雄縣","屏東縣",
        "花蓮縣","台東縣","澎湖縣","陽明山管理局","金門縣","連江縣",
        "嘉義市","新竹市"
    };

    
    public void readFile(String fileName)
    {
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line=null; //讀取一行的資料
            StringBuilder data = new StringBuilder(); //讀取的資料
            while( (line = br.readLine()) != null)
            {
                data.append(line + "@");
            }
            
            br.close();
            fr.close();
            
            setId(data.toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void setId(String str)
    {
        String line[] = str.split("@");
        id=null;
        result=null;
        
        ids = new List[line.length];
        
        for(int i=0; i< line.length; i++)
        {
            String data[] =line[i].split("\t");
            id = data[0];
            Check(id);
            ids[i]=new List(id,result,Check(id));
        }
        
    }
    
    public void printResult()
    {
        for (List id : ids)
        {
            System.out.printf("%s\t%s\n", id.getId(), id.getResult());
        }
    }
    
    public  int Check(String id)
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
                    result="格式不符，第一位須為大寫字母";
                    correct=0;
                    return correct;
                }
                
                else
                {
                    if(c[1]=='1'||c[1]=='2') //檢查第二位數字
                    {
                        if(c[1]=='1')
                        {
                            sex="男性";
                        }
                        else
                        {
                            sex="女性";
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
                            result=place[first-10] + " " + sex;
                            correct=1;
                            return correct;
                        }
                        else
                        {
                            result="身份證字號錯誤";
                            correct=0;
                            return correct;
                        }
                    }
                    else
                    {
                        result="格式不符，第一位須為1或2";
                        correct=0;
                        return correct;
                    }
                }
            }
            else
            {
                result="長度不符，長度須為10";
                correct=0;
                return correct;
            }
        }
        catch(Exception e)
        {
            result="格式不符";
            correct=0;
            return correct;
        }
    }
    
    
    public void writeFile(String fileName, String id, String result,int num)
    {
        try
        {
            File file = new File(fileName);
            
            if(file.exists() && (num!=0))
            {
                FileWriter fw = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write( id + ",  " + result);
                bw.newLine();
                bw.close();
                fw.close();
            }
            else
            {
                FileWriter fw = new FileWriter(file,false);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write( id + ",  " + result);
                bw.newLine();
                bw.close();
                fw.close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private int c=0;
    private int e=0;
    public void Write()
    {
        
        for (List id : ids)
        {
            String file;
            
            if (id.getCorrect() == 1)
            {
                file="correct.txt";
                writeFile(file, id.getId(), id.getResult(), c);
                c+=1;
            }
            else if (id.getCorrect() == 0)
            {
                file="error.txt";
                writeFile(file, id.getId(), id.getResult(), e);
                e+=1;
            }
        }
    }
    
}
