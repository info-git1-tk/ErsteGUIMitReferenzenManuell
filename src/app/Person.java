/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author r115
 */
public class Person {
   
    private String name;
    private String vorname;
    private int id;
    private boolean irgendwas;

    
    public Person(String name, String vorname, int id, boolean irgendwas) {
        this.name = name;
        this.vorname = vorname;
        this.id = id;
        this.irgendwas = irgendwas;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isIrgendwas() {
        return irgendwas;
    }
    public void setIrgendwas(boolean irgendwas) {
        this.irgendwas = irgendwas;
    }
    
    
    public String anzeigen() {
        return "Eingetragene Person: \n" + this.name + ", " + this.vorname + " mit der ID: " + this.id + " und " + this.irgendwas;
    }
    
}
