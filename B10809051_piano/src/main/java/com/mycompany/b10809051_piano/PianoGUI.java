package com.mycompany.b10809051_piano;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



/**
 *
 * @author j1461
 */
public class PianoGUI extends JFrame{
    public JLabel show = new JLabel("Play the Piano!");
    
    private String WhiteKey[]={"Do","Re","Mi","Fa","So","La","Si","Do"};
    private String BlackKey[]={"#DO", "#Re", "#Fa", "#So", "#La"};
    
    private Rectangle White[] = {
            new Rectangle(0,0,90,400),
            new Rectangle(100,0,90,400),
            new Rectangle(200,0,90,400),
            new Rectangle(300,0,90,400),
            new Rectangle(400,0,90,400),
            new Rectangle(500,0,90,400),
            new Rectangle(600,0,90,400),
            new Rectangle(700,0,90,400),
    };
    
    private Rectangle Black[] = {
            new Rectangle(75,0,40,250),
            new Rectangle(175,0,40,250),
            new Rectangle(375,0,40,250),
            new Rectangle(475,0,40,250),
            new Rectangle(575,0,40,250),
    };
    
    private PianoPanel panel = new PianoPanel();
    
    public PianoGUI(){
//            for(int i=0;i<=7;i++){
//                White[i].setRect(i*100, 0, 90, 400);
//            }
//            
//            for(int j=0;j<=5;j++){
//                if (j==2) continue;
//                Black[j].setRect(j*100+75, 0, 40, 250);
//            }

        show.setFont(new Font(show.getFont().getName(), show.getFont().getStyle(), 30));
        this.add(this.show, "South");
        panel.setLayout(new FlowLayout());
        this.add(panel);
        panel.addMouseListener( new MouseClickHandler());
    }
    
    public class PianoPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(new Color(255,255,255));
            for (int i=0 ;i<=7; i++){
                g2.fill(White[i]);
            }
            g2.setColor(new Color(0,0,0));
            for (int j=0;j<=4;j++){
                g2.fill(Black[j]);
            }
        }
    }
    
    private class MouseClickHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i=0;i<=7;i++){
                if (White[i].getBounds().contains(e.getPoint()))
                    show.setText(WhiteKey[i]);
            }
            for (int j=0;j<=4;j++){
                if (Black[j].getBounds().contains(e.getPoint()))
                    show.setText(BlackKey[j]);
            }
            super.mouseClicked(e);
        }
    }
}
