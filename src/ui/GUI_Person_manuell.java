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
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author wagnerbe
 */
public final class GUI_Person_manuell extends JFrame implements ActionListener {
    
    private final GridBagLayout layout = new GridBagLayout();
    private final GridBagConstraints gbc = new GridBagConstraints();
    
    private final JPanel mainPanel = new JPanel();
    
    private ArrayList<Person> personen = new ArrayList<>();
    
    // Buttons:
    JButton addButton = new JButton("Hinzufügen");
    JButton removeButton = new JButton("Entfernen");
    
    
    public GUI_Person_manuell() {
        this.add(this.mainPanel);
        this.mainPanel.setLayout(this.layout);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 0;
        
        this.addButton.addActionListener(e -> addPersonAction());
        this.removeButton.addActionListener(e -> removePersonAction());
        
        this.setupWindow();
        this.showWindow();
        this.initUI();
    }
    
    public void setupWindow() {
        this.setPreferredSize(new Dimension(800,600));
        this.setMinimumSize(new Dimension(640,480));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
    }
    
    public void showWindow() {
        this.setVisible(true);
    }
    
    public void initUI() {
        this.mainPanel.removeAll();
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 2;
        this.mainPanel.add(this.addButton,gbc);
        this.mainPanel.add(this.removeButton,gbc);
        
        gbc.gridwidth = 1;
        for(Person person : this.personen) {
            gbc.gridy++;
            this.mainPanel.add(new JTextField(person.getVorname()),gbc);
            this.mainPanel.add(new JTextField(person.getName()),gbc);
            this.mainPanel.add(new JTextField(String.valueOf(person.getId())),gbc);
            
            String irgendwasIst = "Es ist nichts!";            
           
            if(person.isIrgendwas()) {
                irgendwasIst = "Es ist was.";
            }            
            this.mainPanel.add(new JTextField(irgendwasIst),gbc);
        }
        gbc.gridy++;
        gbc.weighty = 1;
        this.mainPanel.add(Box.createGlue(),gbc);
       
        
        this.mainPanel.updateUI();
    }

    
    public void addPersonAction() {
        System.out.println("Hinzufügen");
        Person testPerson = new Person("Person","Vorname",24,true);
        this.personen.add(testPerson);
        this.initUI();
    }
    
    public void removePersonAction() {
        System.out.println("Entfernen");
        try {
            this.personen.remove(this.personen.size()-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Das Array ist bereits leer.");
        }

        this.initUI();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    
    
}
