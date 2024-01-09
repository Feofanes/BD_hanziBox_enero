
package Entradas;

import java.util.ArrayList;

public class Unidad_final {
    
    private ArrayList obj;
    
    private String traduccion;
    private String ejemplo;
    
    
    //  CONTRUCTOR

    public Unidad_final(ArrayList obj, String traduccion, String ejemplo) {
        this.obj = obj;
        this.traduccion = traduccion;
        this.ejemplo = ejemplo;
    }
    

   
    
    public Unidad_final() {
        
        
    }

    

    public ArrayList getObj() {
        return obj;
    }

    //  GETTERS AND SETTERS
    public void setObj(ArrayList obj) {
        this.obj = obj;
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
    
    
    
    
    
}
