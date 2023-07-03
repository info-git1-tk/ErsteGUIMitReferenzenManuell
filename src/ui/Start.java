/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

/**
 *
 * @author r115
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FlatLightLaf.setup();

        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch (Exception ignored)
        {

        }

        SwingUtilities.invokeLater(GUI_Haupt::new);

    }
    
}
