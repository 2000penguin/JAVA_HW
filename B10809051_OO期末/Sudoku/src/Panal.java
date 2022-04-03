
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Panal extends javax.swing.JPanel {

    private Timer timer;
    private JButton nbtn = new JButton("new game");
    private static JTextField[][] boxes;
    private JLabel label = new JLabel("      Timer :00 : 00 : 00");
    private JPanel[][] paneles;
    private JPanel center, bPanel, levelPanel;
    private JButton nBtn, cBtn, eBtn, hardBtn, midBtn, easyBtn, slove, about;
    private int[][] temp = new int[9][9];
    private int[][] grid = new int[9][9];
    private int counter = 0;

    public JTextField newtextfield() {
        JTextField j = new JTextField("");
        j.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        j.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
        j.setHorizontalAlignment(JTextField.CENTER);
        /*-------------------滑鼠監聽----------------*/
        j.addMouseListener(new MouseAdapter() {

            @Override
            //滑鼠移入後變色
            public void mouseEntered(MouseEvent e) {
                if (j.isEditable()) {
                    ((JTextField) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.decode("#f6ea80")));
                    ((JTextField) e.getSource()).setBackground(Color.decode("#f6ea80"));
                }
            }
            //滑鼠移出後變回來
            @Override
            public void mouseExited(MouseEvent e) {
                if (j.isEditable()) {
                    ((JTextField) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.lightGray));
                    ((JTextField) e.getSource()).setBackground(Color.white);
                }
            }
        });
        /*------------------------------------------------*/

        j.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //輸入放開後變色
                if (j.isEditable()) {
                    ((JTextField) e.getSource()).setForeground(Color.blue);
                } else {
                    ((JTextField) e.getSource()).setForeground(Color.black);
                }
            }
        });
        return j;
    }

    public Panal() {
        setLayout(null);
        /*------------------------主要畫面-------------------------------------*/
        center = new JPanel();
        center.setLayout(new GridLayout(3, 3));//網格佈局 3*3
        center.setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        add(center);

        boxes = new JTextField[9][9];//放數子
        paneles = new JPanel[3][3];//放九宮格
        label.setForeground(Color.black);
        label.setBorder(BorderFactory.createLineBorder(Color.red, 4));
        label.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));

        //畫邊線
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                paneles[i][j] = new JPanel();
                paneles[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                paneles[i][j].setLayout(new GridLayout(3, 3));
                center.add(paneles[i][j]);
            }
        }
        /*------------------------box 的輸入區域加入 paneles-------------------------------------*/

        for (int n = 0; n < 9; n++) {
            for (int i = 0; i < 9; i++) {
                boxes[n][i] = newtextfield();
                int fm = (n + 1) / 3;
                if ((n + 1) % 3 > 0) {
                    fm++;
                }
                int cm = (i + 1) / 3;
                if ((i + 1) % 3 > 0) {
                    cm++;
                }
                paneles[fm - 1][cm - 1].add(boxes[n][i]);
            }
        }
        /*------------------------放置按鈕的 Panel-------------------------------------*/

        bPanel = new JPanel();
        bPanel.setBackground(Color.decode("#AABFFF"));
        bPanel.setBorder(BorderFactory.createLineBorder(Color.black, 6, true));
        bPanel.setLayout(new GridLayout(4, 3, 0, 20));

        /*------------------------Timer 的 Listener-------------------------------------*/
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                label.setText(TimeFormat(counter));
                counter++;

            }
        };

        /*------------------------新遊戲按鈕-------------------------------------*/
        nBtn = new JButton("新遊戲");
        nbtn.setSize(20, 50);
        timer = new Timer(1000, action);
        nBtn.addActionListener(new ActionListener() {

            @Override
            //點選後開始、重置計時並開始新遊戲
            public void actionPerformed(ActionEvent e) {
                counter = 0;
                timer.start();
                restgame();
                Sudoku.newGame();

            }
        });

        /*------------------------檢測是否正確按鈕-------------------------------------*/
        cBtn = new JButton("檢測是否正確 +30s懲罰");

        cBtn.addActionListener(new ActionListener() {
            @Override
            //檢測如果為正確、錯誤背景變色直到滑鼠移入
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (!boxes[i][j].isEditable()) {
                            continue;
                        } else if (boxes[i][j].getText().equals(String.valueOf(grid[i][j]))) {
                            boxes[i][j].setBackground(Color.decode("#C0DCD9"));
                        } else if (boxes[i][j].getText().isEmpty()) {
                            boxes[i][j].setBackground(Color.WHITE);
                            continue;
                        } else {
                            boxes[i][j].setBackground(Color.red);
                        }
                    }
                }
                 counter += 30;
            }
        });

        /*------------------------離開按鈕-------------------------------------*/
        eBtn = new JButton("離開");

        eBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        /*------------------------Hard遊戲模式按鈕-------------------------------------*/
        easyBtn = new JButton("Hard");

        easyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restgame();
                counter = 0;
                timer.start();
                Sudoku.setlevel(4);
                Sudoku.newGame();
            }
        });

        /*------------------------Mideum遊戲模式按鈕-------------------------------------*/
        midBtn = new JButton("Mideum");

        midBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restgame();
                counter = 0;
                timer.start();
                Sudoku.setlevel(3);
                Sudoku.newGame();

            }
        });
        /*------------------------Easy遊戲模式按鈕-------------------------------------*/
        hardBtn = new JButton("Easy");

        hardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restgame();
                counter = 0;
                timer.start();
                Sudoku.setlevel(2);
                Sudoku.newGame();
            }
        });

        /*------------------------顯示出答案按鈕-------------------------------------*/
        slove = new JButton("放棄並顯示答案");

        slove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                counter = 0;
                label.setText(TimeFormat(counter));
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        boxes[i][j].setText(String.valueOf(grid[i][j]));
                    }
                }
            }
        });

        /*------------------------將按鈕加入Panel-------------------------------------*/
        bPanel.add(hardBtn);
        bPanel.add(midBtn);
        bPanel.add(easyBtn);
        bPanel.add(nBtn);
        bPanel.add(cBtn);
        bPanel.add(eBtn);
        bPanel.add(slove);
        bPanel.add(label);

        add(bPanel, "South");

    }

    //給Sudoku.class設定陣列
    public void setarray(int[][] grid, int[][] temp) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.temp[i][j] = temp[i][j];
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    //給Sudoku.class呼叫將陣列值填入
    public void setTextLable() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.temp[i][j] != 0) {
                    //已給的數字不可被修改
                    boxes[i][j].setText(String.valueOf(this.temp[i][j]));
                    boxes[i][j].setEditable(false);
                    boxes[i][j].setBackground(Color.decode("#C0DCC0"));
                } else {
                    boxes[i][j].setText("");
                }
            }
        }
    }

    //重設遊戲(清空格子內的數字)
    public static void restgame() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boxes[i][j].setForeground(Color.black);
                boxes[i][j].setEditable(true);
                boxes[i][j].setBackground(Color.WHITE);
            }
        }
    }

    //時間正規化顯示
    private String TimeFormat(int count) {
        int hours = count / 3600;
        int minutes = (count - hours * 3600) / 60;
        int seconds = count - minutes * 60;

        return String.format("      Timer :" + "%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds);
    }

}
