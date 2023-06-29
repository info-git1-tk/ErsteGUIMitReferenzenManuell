/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.SwingUtilities;

/**
 *
 * @author r115
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Haupt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Haupt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Haupt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Haupt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Erzeugen eines Fenster-objektes (Hauptfenster)
        GUI_Haupt guiHaupt =  new GUI_Haupt();
        // Hauptfenster auf sichtbar setzen
        guiHaupt.setVisible(true);
        
         // Erzeugen eines weiteren Fenster-objektes, welches 
         // noch nicht sichtbar ist
        GUI_Person guiPerson = new GUI_Person();
        
        // Erstellen der Verknüpfungen zwischen den Fenstern:
        // Mit Hilfe der Zuweisungsmethoden werden den jeweiligen
        // Referenzattributen jeweils ein Zeiger auf das andere Fenster-Objekt
        // zugewiesen
        
        guiHaupt.refGuiPerson(guiPerson);
        guiPerson.refGuiHaupt(guiHaupt);

    }
    
}
