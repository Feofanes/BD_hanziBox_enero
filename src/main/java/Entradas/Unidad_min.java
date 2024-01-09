
package Entradas;

public class Unidad_min {
    
    private String simbolo;
    private String radical;
    private String pinyin;
    private String traduccion;
    private String ejemplo;
    
    private String nombre;
    
    
    //  CONSTRUCTOR

    public Unidad_min(String simbolo, String radical, String pinyin, String traduccion, String ejemplo) {
        this.simbolo = simbolo;
        this.radical = radical;
        this.pinyin = pinyin;
        this.traduccion = traduccion;
        this.ejemplo = ejemplo;
    }

    public Unidad_min() {
    }
    
    public Unidad_min(String nombre) {
        
        this.nombre = nombre;
    }
    
    
    
    
    //  GETTERS AND SETTERS

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getRadical() {
        return radical;
    }

    public void setRadical(String radical) {
        this.radical = radical;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
    
    
    
}
