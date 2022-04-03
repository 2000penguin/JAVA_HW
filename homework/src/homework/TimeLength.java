package homework;

/**
 *
 * @author jenny
 */
public class TimeLength 
{
    
    private static final int HR_TO_MIN=60;
    private static final int MIN_TO_SEC=60;
    private static final int HR_TO_SEC=3600;
    
    private final String pattern = "%02d";
    
    private int _time;
    private int _hr;
    private int _min;
    private int _sec;
    
    public void setTime(int t)
    {
        _time=t;
    }
    
    public void showTime()
    {
        _hr= _time / HR_TO_SEC;
        _min= (_time - (_hr * HR_TO_SEC)) / MIN_TO_SEC;
        _sec= _time % MIN_TO_SEC;
        
        System.out.println("The current length of time (second): " + _time);
        
        System.out.print("The current length of time (hh:mm:ss): ");
        System.out.println(String.format(pattern, _hr) + ":" +
                String.format(pattern, _min) + ":" +
                String.format(pattern, _sec)) ;
    }
    
    public void adjustTime(int adjust)
    {
        _time+=adjust;
    }
    
    public int strToTime(String str)
    {
        int sign=1;
        String strr;
        if(str.charAt(0)=='-')
        {
            sign=-1;
            strr=str.substring(1);
        }
        else
        {
            strr=str;
        }
        if(strr.matches("\\d+[:]\\d+[:]\\d+"))
        {
            String[] tem=strr.split(":");
            int num=0;
            for(int i =0; i<3; i++)
            {
                num+=Integer.parseInt(tem[i])*Math.pow(60,2-i);
            }
            if(sign==1)
            {
                System.out.println("Time: "+strr+ "\n");
            }
            else if(sign==-1)
            {
                System.out.println("Time: -"+strr+ "\n");
            }
            return num*sign;
        }
        else if(strr.matches("\\d*"))
        {
            System.out.println("Time: "+Integer.parseInt(strr)*sign+ "\n");
            return Integer.parseInt(strr)*sign;
        }
        else
        {
            System.out.println("The time is wrong.\n");
            return 0;
        }
    }
}
