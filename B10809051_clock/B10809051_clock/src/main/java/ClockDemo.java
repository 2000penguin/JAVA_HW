import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

public class ClockDemo extends JFrame implements Runnable {

    private final int width = 500;
    private final int height = 500;
    
    private int h = 1;
    private int min = 1;
    private int sec = 1;
    
    private double R = (width-100)/2.0;
    private double P =  Math.PI/6;
    
    private boolean tag = true;
    
    private Map<Integer,Double> xMap = new HashMap<Integer,Double>();
    private Map<Integer,Double> yMap = new HashMap<Integer,Double>();
    
    public ClockDemo() {
        
        this.setTitle("A Clock");
        this.setSize(new Dimension(width,height));
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
        for(int i=1;i<=12;i++) {
            double e = P*i;
            double x = Math.sin(e)*R + R + 50;
            double y = R + 50 - Math.cos(e)*R ;
            
            xMap.put(i, x);
            yMap.put(i, y);
        }
 
        new Thread(this).start();
    }
    
    public int calX(double P,int i,int R1){
        double e = P*i;
        double x = Math.sin(e)*R1 + R + 50;
        return (int)x;
    }
	
    public int calY(double P,int i,int R1){
            double e = P*i;
            double y = R + 50 - Math.cos(e)*R1 ;
            return (int)y;
    }
    
    @Override
    public void paint(Graphics g){

            Graphics2D g2 = (Graphics2D) g;
            
            g2.setColor(Color.WHITE);
            g2.fillRect(0,0,width,height);

            g2.setColor(Color.BLUE);
            g2.drawOval(35,35,width-70,height-70);

            double x = 0, y = 0;
            for(int i=1;i<=12;i++) {

                    double e = P*i;
                    x = xMap.get(i);
                    y = yMap.get(i) ;

                    g2.drawString(String.valueOf(i),(int)x,(int) y);
            }
            tag = false;	
            
            g2.fillRect(30+(width-70)/2,30+(height-70)/2,10,10);
            
            //HOUR
            g2.setColor(Color.BLACK);
            if(h>12){

                    h -= 12;
            }
            g2.drawLine(35+(width-70)/2,35+(width-70)/2,calX(Math.PI/6+Math.PI/120,h,60), calY(Math.PI/6+Math.PI/120,h,60));
            
            //MINUTE
            g2.setColor(Color.BLACK);
            g2.drawLine(35+(width-70)/2,35+(width-70)/2,calX(Math.PI/30,min,100), calY(Math.PI/30,min,100));
            
            //SECOND
            g2.setColor(Color.BLUE);
            g2.drawLine(35+(width-70)/2,35+(width-70)/2,calX(Math.PI/30,sec,150), calY(Math.PI/30,sec,150));

            g2.drawString(h+":"+min+":"+sec,20 + (width-75)/2,100);
            
            g2.dispose();
    }
    
    @Override
    public void run() {
            Timer timer = new Timer();
            timer.schedule(new TimerTask(){

                    @Override
                    public void run() {

                            h = new java.util.Date().getHours();
                            min = new java.util.Date().getMinutes();
                            sec = new java.util.Date().getSeconds();

                            repaint();
                    }
            },0,1000);
    }
    
    public static void main(String[] args) {
        ClockDemo clock = new ClockDemo();
    }
    
}
