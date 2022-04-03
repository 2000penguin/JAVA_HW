package hw7;

import java.util.Scanner;

/**
 *
 * @author jenny
 */
public class TicTacToe 
{
    private char[][] board;
    private char currentPlayer;
    private char winner='X';
    
    int row;
    int col;
    
    public TicTacToe()
    {
        board=new char[3][3];
        currentPlayer=winner;
        initializeBoard();
    }
    
    // Set/Reset the board back to all empty values.
    public final void initializeBoard()
    {
        for(int i=0; i<=2; i++)
        {
            for(int j=0; j<=2; j++)
            {
                board[i][j] = '-';
            }
        }
    }
    
    public void Play()
    {
        do
        {
            int OK=0;
            do
            {
                Scanner scanner=new Scanner(System.in);
                System.out.print("Player-" + currentPlayer + ", enter your move(row[1-3],column[1-3])：");
                String place=scanner.next();
                try
                {
                    if(place.matches("\\d+[,]\\d+"))
                    {
                        String[] units = place.split(",");
                        row=Integer.parseInt(units[0])-1;
                        col=Integer.parseInt(units[1])-1;
                        
                        if ((row >= 0) && (row < 3))
                        {
                            if ((col >= 0) && (col < 3))
                            {
                                placeMark(row, col);
                                OK=1;
                            }
                            else
                            {
                                System.out.println("3.The value you entered is invalid! Please try again.");
                                OK=0;
                            }
                        }
                        else
                        {
                            System.out.println("3.The value you entered is invalid! Please try again.");
                            OK=0;
                        }
                    }
                    else
                    {
                        System.out.println("1.The value you entered is invalid! Please try again.");
                        OK=0;
                    }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("2.The value you entered is invalid! Please try again.");
                    OK=0;
                }
            }while (OK==0);
            
            printBoard();
            changePlayer();
            
        }while(!checkForWin() && !isBoardFull());
        
        if (isBoardFull() && !checkForWin())
        {
            System.out.println("It's a Draw!"); //平手
        }
        else
        {
            // printBoard();
            changePlayer();
            System.out.println("Player-" +currentPlayer+ " is the winner!");
            winner = currentPlayer;
        }
        
    }
    
    public void printBoard()
    {
        System.out.println("-------------");
        for (int i = 0; i<=2; i++)
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
    public boolean isBoardFull()
    {
        boolean isFull = true;
        for (int i = 0; i<=2; i++)
        {
            for (int j = 0; j<=2; j++)
            {
                if (board[i][j] == '-')
                {
                    isFull = false;
                }
            }
        }
        return isFull;
    }
    
    public void placeMark(int row, int col)
    {
        if (board[row][col] == '-')
        {
            board[row][col] = currentPlayer;
        }
    }
    
    public void changePlayer()
    {
        if (currentPlayer == 'X')
        {
            currentPlayer = 'O';
        }
        else
        {
            currentPlayer = 'X';
        }
    }
    
    public boolean checkForWin()
    {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }
    
    private boolean checkRowsForWin() //水平線
    {
        for (int i = 0; i<=2; i++)
        {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true)
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkColumnsForWin() //垂直線
    {
        for (int i = 0; i<=2; i++)
        {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true)
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkDiagonalsForWin() //交叉
    {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || 
                (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }
    
    private boolean checkRowCol(char c1, char c2, char c3) 
    {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }
}
