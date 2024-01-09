
package Entradas;

import javax.swing.JComboBox;

public class Hanzi {
    
    //  ATRIBUTOS
    
    private String idiograma;
    private String fonetica;
    private String traduccion;
    private String ejemplo;
    private String radical;
    
    //  CONTRUNSTRUCTOR

    public Hanzi(String idiograma, String fonetica, String traduccion, String ejemplo, JComboBox radical) {
        this.idiograma = idiograma;
        this.fonetica = fonetica;
        this.traduccion = traduccion;
        this.ejemplo = ejemplo;
    }

    public Hanzi(String idiograma) {
        this.idiograma = idiograma;
    }

    public Hanzi(String idiograma, String fonetica) {
        this.idiograma = idiograma;
        this.fonetica = fonetica;
    }

    public Hanzi(String idiograma, String fonetica, String traduccion) {
        this.idiograma = idiograma;
        this.fonetica = fonetica;
        this.traduccion = traduccion;
    }

    public Hanzi() {
    }
    
    
    //  GETTERS and SETTERS

    public String getIdiograma() {
        return idiograma;
    }

    public void setIdiograma(String idiograma) {
        this.idiograma = idiograma;
    }

    public String getFonetica() {
        return fonetica;
    }

    public void setFonetica(String fonetica) {
        this.fonetica = fonetica;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }

    public String getEjemplo() {
        return ejemplo;
    }

    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }

    public String getRadical() {
        return radical;
    }

    public void setRadical(String radical) {
        this.radical = radical;
    }
    
    
    
    
    
    
    
}
