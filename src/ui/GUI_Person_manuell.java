/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import app.Person;
import java.awt.GridBagConstraints;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wagnerbe
 */
public final class GUI_Person_manuell extends JFrame implements ActionListener {

    private final GridBagConstraints gbc = new GridBagConstraints();
    private final JPanel mainPanel = new JPanel();
    private final JTable personTable = new JTable();
    
    // Buttons:
    JButton addButton = new JButton("Hinzufügen");
    JButton removeButton = new JButton("Entfernen");
    
    
    public GUI_Person_manuell() {
        this.add(this.mainPanel);
        GridBagLayout layout = new GridBagLayout();
        this.mainPanel.setLayout(layout);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 0;
        
        this.addButton.addActionListener(e -> addPersonAction());
        this.removeButton.addActionListener(e -> removePersonAction());
        
        this.setupWindow();
        this.initUI();
        this.showWindow();

    }
    
    public void setupWindow() {



                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }


        this.setPreferredSize(new Dimension(800,600));
        this.setMinimumSize(new Dimension(800,600));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
    }
    
    public void showWindow() {
        this.setVisible(true);
    }
    
    public void initUI() {

        DefaultTableModel model = (DefaultTableModel) this.personTable.getModel();
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

        model.addColumn("ID");
        model.addColumn("Vorname");
        model.addColumn("Nachname");
        model.addColumn("Ist irgendwas?");
        
        gbc.gridy = 0;
        gbc.weighty = 0;
        this.mainPanel.add(this.addButton,gbc);
        this.mainPanel.add(this.removeButton,gbc);
        gbc.gridwidth = 2;
        this.mainPanel.add(Box.createGlue(),gbc);

        gbc.gridy++;
        gbc.insets = new Insets(10,0,0,0);
        gbc.gridwidth = 4;
        this.mainPanel.add(new JScrollPane(this.personTable),gbc);

        gbc.gridy++;
        gbc.weighty = 1;
        this.mainPanel.add(Box.createGlue(),gbc);
    }

    
    public void addPersonAction() {
        System.out.println("Hinzufügen");


        DefaultTableModel model = (DefaultTableModel) this.personTable.getModel();
        Person person = new Person("Person","Vorname",24,true);

        // TODO: TextFelder verwenden, um Attribute der Person festlegen zu können.

        String irgendwasIst = "Es ist nichts!";
        if(person.isIrgendwas()) {
            irgendwasIst = "Es ist was.";
        }

        model.addRow(new Object[]{
                person.getId(),
                person.getVorname(),
                person.getName(),
                irgendwasIst
        });

        this.mainPanel.updateUI();
    }
    
    public void removePersonAction() {
        System.out.println("Entfernen");

        DefaultTableModel model = (DefaultTableModel) this.personTable.getModel();

        try {
            model.removeRow(model.getRowCount()-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Das Array ist bereits leer.");
        }

        this.mainPanel.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    
    
}
