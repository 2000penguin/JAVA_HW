/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.b10809051_piano;

import javax.swing.JFrame;

/**
 *
 * @author j1461
 */
public class PianoDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PianoGUI gui = new PianoGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(900, 500);
        gui.setVisible(true);
    }
    
}
