/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.*;

/**
 *
 * @author r115
 */
public class GUI_Haupt extends javax.swing.JFrame {
    
    //Referenzattribut für den Zugriff auf das Fenster-objekt guiPerson
    private GUI_Person guiPerson;
    private GUI_Person_manuell gui_person_manuell;

    /**
     * Creates new form GUI_Haupt
     */
    public GUI_Haupt() {
        initComponents();
        this.setVisible(true);
    }
    
    //Zuweisungsmethode für das Referenzattribut (für Assoziation) 
    
    public void refGuiPerson(GUI_Person guiPerson){
        this.guiPerson = guiPerson;
    }
    public void refGuiPersonManuell(GUI_Person_manuell guiPerson){
        this.gui_person_manuell = guiPerson;
    }

    // Zugriffsmethode für das Referenzattribut:  get- Methode

    public GUI_Person getGuiPerson() {
        return guiPerson;
    }

    public GUI_Person_manuell getGui_person_manuell() {
        return gui_person_manuell;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLueberschrift = new javax.swing.JLabel();
        jB_Start = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jLueberschrift.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLueberschrift.setText("Willkommen in TK 2.0");

        jB_Start.setText("Start");
        jB_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_StartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLueberschrift)
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jB_Start)
                        .addGap(162, 162, 162))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLueberschrift)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(jB_Start)
                .addGap(53, 53, 53))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_StartActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(GUI_Person_manuell::new);
        this.setVisible(false);
    }//GEN-LAST:event_jB_StartActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Start;
    private javax.swing.JLabel jLueberschrift;
    // End of variables declaration//GEN-END:variables
}
