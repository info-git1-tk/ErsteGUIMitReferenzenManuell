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
        
        SwingUtilities.invokeLater(GUI_Person_manuell::new);
       
    }
    
}
