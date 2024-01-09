
package Entradas;

import java.util.ArrayList;

public class Hanzi_molde {
    
    //  ATRIBUTOS
    
    private ArrayList idiograma_conjunto;
    private ArrayList pinyin_conjunto;
    private ArrayList radical_conjunto;
    
    //  CONSTRUCTOR

    public Hanzi_molde(ArrayList idiograma_conjunto, ArrayList pinyin_conjunto, ArrayList radical_conjunto) {
        this.idiograma_conjunto = idiograma_conjunto;
        this.pinyin_conjunto = pinyin_conjunto;
        this.radical_conjunto = radical_conjunto;
    }

    public Hanzi_molde(ArrayList idiograma_conjunto) {
        this.idiograma_conjunto = idiograma_conjunto;
    }

    public Hanzi_molde(ArrayList idiograma_conjunto, ArrayList pinyin_conjunto) {
        this.idiograma_conjunto = idiograma_conjunto;
        this.pinyin_conjunto = pinyin_conjunto;
    }

    public Hanzi_molde() {
    }
    
    //  GETTERS ANS SETTERS

    public ArrayList getIdiograma_conjunto() {
        return idiograma_conjunto;
    }

    public void setIdiograma_conjunto(ArrayList idiograma_conjunto) {
        this.idiograma_conjunto = idiograma_conjunto;
    }

    public ArrayList getPinyin_conjunto() {
        return pinyin_conjunto;
    }

    public void setPinyin_conjunto(ArrayList pinyin_conjunto) {
        this.pinyin_conjunto = pinyin_conjunto;
    }

    public ArrayList getRadical_conjunto() {
        return radical_conjunto;
    }

    public void setRadical_conjunto(ArrayList radical_conjunto) {
        this.radical_conjunto = radical_conjunto;
    }
    
    
    
}
