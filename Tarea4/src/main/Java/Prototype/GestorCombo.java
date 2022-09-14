package Prototype;

import enums.Drink;
import enums.ECombo;
import MenuItem.Combo;
import java.awt.*;
import java.util.Hashtable;
/*
* Clase que contiene la tabla de hash y sus prototipos
* */
public class GestorCombo {

    private Hashtable hashCombos = new Hashtable();

    public GestorCombo(){

    }
    public void addCombo(ECombo llave, Combo unCombo){
        this.hashCombos.put(llave, unCombo); //tablas hash van indexadas
    }
    public Combo getCombo(ECombo nombre){
        return (Combo)hashCombos.get(nombre);
    }
    public Combo getClon(ECombo nombre){
        Combo comboClonar = (Combo)hashCombos.get(nombre);
        return (Combo)comboClonar.clone();
    }

}
