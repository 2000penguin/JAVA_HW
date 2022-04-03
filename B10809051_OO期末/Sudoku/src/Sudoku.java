
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JFrame;

public class Sudoku {

    static JFrame frame;
    static Panal p;
    private  static int[][] grid;
    private static int[][] temp;
    private static Random ran = new Random();
    private static int level = 2;

    public static void main(String[] args) {
        //初始化
        grid = new int[9][9];//存放題目
        temp = new int[9][9];//存放非空格/空格數列
        frame = new JFrame();
        frame.setResizable(false);
        frame.setLocation(320, 40);
        frame.setSize(650, 650);
        frame.setTitle("數獨遊戲！");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new Panal();
        frame.setContentPane(p);
        frame.setVisible(true);
    }

    //產生符合數獨規則的題目與解答
    public static void newGame() {
        int k = 0;
        ArrayList<Integer> randomnumber = getRandomNum();
        //將陣列依每次隔列照順序填入(填入25個)
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = 0;
                if (((j + 2) % 2) == 0 && ((i + 2) % 2) == 0) {
                    grid[i][j] = randomnumber.get(k);
//                    System.out.println(randomnumber.get(k));
                    k++;
                    if (k == 9) {
                        k = 0;
                    }
                }
            }
        }

        if (search(grid)) {
            System.out.println("OK !!");
        }

        //隨機那些要印出來
        int rann = ran.nextInt(level);
        int c = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                temp[i][j] = 0;//暫存歸零
                if (c < rann) {
                    c++;
//                    System.out.println(c);
                    continue;
                } else {
                    rann = ran.nextInt(level);//取得0到指定難度的隨機數(level越低數字被印出的可能性越高)
                    c = 0;
                    temp[i][j] = grid[i][j];
                }
            }
        }

        p.setarray(grid, temp); //將陣列放入Panel
        p.setTextLable();
    }

    public static int[][] getFreeCellList(int[][] grid) {
        //統計尚未被填入的個數
        int numberOfFreeCells = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    numberOfFreeCells++;
                }
            }
        }

        //紀錄為零的X,Y位置(每次皆為固定)
        int[][] freeCellList = new int[numberOfFreeCells][2];
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    freeCellList[count][0] = i;
                    freeCellList[count][1] = j;
//                    System.out.println(i+","+j);
                    count++;
                }
            }
        }

        return freeCellList;
    }

    public static boolean search(int[][] grid) {
        int[][] freeCellList = getFreeCellList(grid);
        int k = 0;
        boolean found = false;

        while (!found) {
            //將為零的數一個個取出
            int i = freeCellList[k][0];
            int j = freeCellList[k][1];
            //先將其設為1
            if (grid[i][j] == 0) {
                grid[i][j] = 1;
            }
            //偵測為1時是否合法
            if (isAvaible(i, j, grid)) {
                //如果 k+1=freeCellList.length 表示題目建置完成(零的部分被填滿)
                if (k + 1 == freeCellList.length) {
                    found = true;
                } else {
                    k++;
                }
            }
            //換判斷該數 +1 是否合法
            else if (grid[i][j] < 9) {
                grid[i][j] = grid[i][j] + 1;
            } 
            //如果 =9 重設到 0 重新驗證
            else {
                while (grid[i][j] == 9) {
                    grid[i][j] = 0;
                    //一開始便碰撞 return false
                    if (k == 0) {
                        return false;
                    }
                    k--; //回朔到上一個數(上一次是失敗的)
                    i = freeCellList[k][0];
                    j = freeCellList[k][1];
                }
                grid[i][j] = grid[i][j] + 1;
            }
        }

        return true;
    }

    public static boolean isAvaible(int i, int j, int[][] grid) {

        //確定在此行合法
        for (int column = 0; column < 9; column++) {
            if (column != j && grid[i][column] == grid[i][j]) {
                return false;
            }
        }

        //確認此列合法
        for (int row = 0; row < 9; row++) {
            if (row != i && grid[row][j] == grid[i][j]) {
                return false;
            }
        }

        //確定在此九宮格合法
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {//      i=5 ,j=2   || row =3  col=0   ||i=3  j=0
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if (row != i && col != j && grid[row][col] == grid[i][j]) {
                    return false;
                }
            }
        }

        return true;//回傳合法
    }

    //取得一隨機排列1~9的ArrayList
    public static ArrayList<Integer> getRandomNum() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (Integer i = 1; i < 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers); //像洗牌一樣，隨機打亂原來的順序。
        return numbers;
    }

    //設定難度
    public static void setlevel(int lev) {
        level = lev;
    }
}
