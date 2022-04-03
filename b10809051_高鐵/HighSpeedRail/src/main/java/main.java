import javax.swing.JFrame;

public class main {

    public static void main(String[] args) {
        ComponentInWindow win = new ComponentInWindow();
        win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        win.setSize( 250, 180 );
        win.setVisible( true );
    }
    
}
