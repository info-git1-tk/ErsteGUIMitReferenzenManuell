/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import app.Person;
import com.formdev.flatlaf.FlatClientProperties;

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

    private int pid = 1;
    
    // Buttons:
    JButton addButton = new JButton("Hinzufügen");
    JButton removeButton = new JButton("Entfernen");

    // Input TextFields:
    JTextField firstnameTextField = new JTextField();
    JTextField lastnameTextField = new JTextField();
    JCheckBox isSomethingCheckBox = new JCheckBox();

    // Labels:
    JTextField actionFeedbackLabel = new JTextField();

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

        this.firstnameTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Vorname" );
        this.lastnameTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nachname" );
        this.isSomethingCheckBox.setText("Ist etwas?");
        this.actionFeedbackLabel.setForeground(Color.RED);

        DefaultTableModel model = (DefaultTableModel) this.personTable.getModel();
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);


        model.addColumn("ID");
        model.addColumn("Vorname");
        model.addColumn("Nachname");
        model.addColumn("Ist irgendwas?");

        //this.personTable.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);

        gbc.insets = new Insets(5,5,5,5);
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        this.mainPanel.add(this.actionFeedbackLabel,gbc);

        gbc.gridwidth = 3;
        gbc.gridy++;
        this.mainPanel.add(Box.createGlue(),gbc);
        gbc.gridwidth = 1;
        this.mainPanel.add(this.removeButton,gbc);


        gbc.gridy++;
        gbc.gridwidth = 1;
        this.mainPanel.add(this.firstnameTextField,gbc);
        this.mainPanel.add(this.lastnameTextField,gbc);
        this.mainPanel.add(this.isSomethingCheckBox,gbc);
        this.mainPanel.add(this.addButton,gbc);

        gbc.gridy++;

        gbc.gridwidth = 4;
        this.mainPanel.add(new JScrollPane(this.personTable),gbc);

        gbc.gridy++;
        gbc.weighty = 1;
        this.mainPanel.add(Box.createGlue(),gbc);
        this.updateRemoveButtonState();

    }

    public void updateRemoveButtonState() {
        this.removeButton.setEnabled(this.personTable.getModel().getRowCount() != 0);
    }

    
    public void addPersonAction() {
        System.out.println("Hinzufügen");

        DefaultTableModel model = (DefaultTableModel) this.personTable.getModel();
        Person person;
        String irgendwasIst = "Es ist nichts!";

        if (this.firstnameTextField.getText().length() > 0 && this.lastnameTextField.getText().length() > 0) {
            person = new Person(this.lastnameTextField.getText(),this.firstnameTextField.getText(),this.pid,this.isSomethingCheckBox.isSelected());

            if(person.isIrgendwas()) {
                irgendwasIst = "Es ist was.";
            }

            model.addRow(new Object[]{
                    person.getId(),
                    person.getVorname(),
                    person.getName(),
                    irgendwasIst
            });

            this.pid++;
            this.actionFeedbackLabel.setText(" ");

        } else {
            System.out.println("Eingaben waren nicht vollständig!");
            this.actionFeedbackLabel.setText("Eingaben waren nicht vollständig!");
        }
        this.updateRemoveButtonState();
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
        this.updateRemoveButtonState();
        this.mainPanel.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    
    
}
