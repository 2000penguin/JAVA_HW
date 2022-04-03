import java.awt.event.ItemEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author j1461
 */
public class ComponentInWindow extends JFrame{
    private JButton Buy_button;
    private JLabel LabelStart, LabelEnd, LabelTicket, LabelNum;
    private JComboBox starJComboBox, endJComboBox;
    
    private ArrayList<String> location = new ArrayList(Arrays.asList("南港", "台北", "板橋","桃園","新竹","苗栗","台中","彰化","雲林","嘉義","台南","左營"));
    private String[] name = {"南港", "台北", "板橋","桃園","新竹","苗栗","台中","彰化","雲林","嘉義","台南","左營"};
    
    private String start = "南港";
    private String end = "南港";
    
    private JRadioButton radioUnanimous, radioPreferential, radioFree, 
            radio1, radio2, radio3, radio4, radio5;
    
    private String Seat = "全票";
    private int BuyNum = 1;
    
    private ButtonGroup SeatGroup, NumGroup;
    
    public ComponentInWindow(){
        
        super( "高鐵購票程式" );
        setLayout( new FlowLayout() );
        LabelStart = new JLabel();
        LabelStart.setText("起點");
        add( LabelStart );
        
        starJComboBox = new JComboBox( name );
        starJComboBox.setMaximumRowCount(12);
        starJComboBox.addItemListener(
            new ItemListener()
            {               
                public void itemStateChanged( ItemEvent event )
                {
                    if ( event.getStateChange() == ItemEvent.SELECTED )
                            start = event.getItem().toString();
                } 
            } 
        ); 
        add( starJComboBox );
        
        
        LabelEnd = new JLabel();
        LabelEnd.setText("終點站");
        add( LabelEnd );
        endJComboBox = new JComboBox( name );
        endJComboBox.setMaximumRowCount(12);
        endJComboBox.addItemListener(
            new ItemListener()
            {               
                public void itemStateChanged( ItemEvent event )
                {
                    if ( event.getStateChange() == ItemEvent.SELECTED )
                        end = event.getItem().toString();
                    } 
            } 
        ); 
        add( endJComboBox );
        
        
        
        LabelTicket = new JLabel(); // JLabel constructor no arguments
        LabelTicket.setText( "票種" );
        add( LabelTicket ); 

        radioUnanimous = new JRadioButton("全票",true);
        radioPreferential = new JRadioButton("優待票",false);
        radioFree = new JRadioButton("自由座",false);

        add(radioUnanimous);
        add(radioPreferential);
        add(radioFree);

        SeatGroup = new ButtonGroup();
        SeatGroup.add(radioUnanimous);
        SeatGroup.add(radioPreferential);
        SeatGroup.add(radioFree);

        radioUnanimous.addItemListener(
        new ProcessRadioButton(SeatGroup) );
        radioPreferential.addItemListener(
        new ProcessRadioButton(SeatGroup) );
        radioFree.addItemListener(
        new ProcessRadioButton(SeatGroup) );
        
        
        LabelNum = new JLabel();
        LabelNum.setText( "張數" );
        add( LabelNum ); 

        radio1 = new JRadioButton("1張",true);
        radio2 = new JRadioButton("2張",false);
        radio3 = new JRadioButton("3張",false);
        radio4 = new JRadioButton("4張",false);
        radio5 = new JRadioButton("5張",false);
        
        add(radio1);
        add(radio2);
        add(radio3);
        add(radio4);
        add(radio5);
        
        NumGroup = new ButtonGroup();
        NumGroup.add(radio1);
        NumGroup.add(radio2);
        NumGroup.add(radio3);
        NumGroup.add(radio4);
        NumGroup.add(radio5);
        
        radio1.addItemListener(
                new ProcessRadioButton(NumGroup) );
        radio2.addItemListener(
                new ProcessRadioButton(NumGroup) );
        radio3.addItemListener(
                new ProcessRadioButton(NumGroup) );
        radio4.addItemListener(
                new ProcessRadioButton(NumGroup) );
        radio5.addItemListener(
                new ProcessRadioButton(NumGroup) );
        
        
        Buy_button = new JButton("買票");
        add(Buy_button);
        
        ProcessBuyButton handler = new ProcessBuyButton();
        Buy_button.addActionListener(handler);
    }
    
    private class ProcessRadioButton implements ItemListener{
        private ButtonGroup buttonGroup;
            
        public ProcessRadioButton(ButtonGroup BG){
            buttonGroup = BG;
        }

        @Override
        public void itemStateChanged(ItemEvent event) {
            if(buttonGroup.equals(SeatGroup)){
                JRadioButton button = (JRadioButton)event.getSource();
                switch (button.getText()) {
                    case "全票":
                        Seat = "全票";
                        break;
                    case "優待票":
                        Seat = "優待票";
                        break;
                    case "自由座":
                        Seat = "自由座";
                        break;
                    default:
                        break;
                }
            }
            
            else{
                JRadioButton button = (JRadioButton)event.getSource();
                switch (button.getText()){
                    case "1張":
                        BuyNum = 1;
                        break;
                    case "2張":
                        BuyNum = 2;
                        break;
                    case "3張":
                        BuyNum = 3;
                        break;
                    case "4張":
                        BuyNum = 4;
                        break;
                    case "5張":
                        BuyNum = 5;
                        break;
                    default:
                        break;
                }
            }
        }
    }
    
    private class ProcessBuyButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            if(start.equals(end)){
            String result = "請選擇不同的起點/終點";
            JOptionPane.showMessageDialog(ComponentInWindow.this, result,"購票失敗",JOptionPane.ERROR_MESSAGE);
        }
        else{
            String result = "您購買了從 " + start + " 到 " + end + " 的 " + Seat + BuyNum + " 張 ";
            JOptionPane.showMessageDialog(ComponentInWindow.this, result,"購票內容",JOptionPane.INFORMATION_MESSAGE);
        }
        }
    }  
}
