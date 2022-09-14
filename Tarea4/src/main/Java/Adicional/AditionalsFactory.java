package Adicional;

import enums.EAditionals;

public class AditionalsFactory {

    public static Aditional create(EAditionals tag){
        Aditional nuevoAdicional;
        switch(tag){
            case POSTREDEMANZANA:
                nuevoAdicional = new PostreDeManzana(5);
                break;
            case PUDIN:
                nuevoAdicional = new Pudin(3);
                break;
            case TRESLECHES:
                nuevoAdicional = new TresLeches(1);
                break;
            default:
                System.out.println("Ingrese un adicional existente ");
                nuevoAdicional = null;
        }
        return nuevoAdicional;
    }

}
