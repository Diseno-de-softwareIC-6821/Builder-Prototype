package org.example;
import Adicional.AditionalsFactory;
import MenuItem.Combo;
import Prototype.PrototypeFactory;
import enums.Drink;
import enums.EAditionals;
import enums.ECombo;
import enums.SideDish;
import Adicional.Aditional;
import java.util.ArrayList;

import static enums.ECombo.TECFISH;

public class Main {
    public static void main(String[] args) {
        //Usando un factory para crear adicionales adicionales
        Aditional PostreDeManzana = AditionalsFactory.create(EAditionals.POSTREDEMANZANA);
        Aditional Pudin = AditionalsFactory.create(EAditionals.PUDIN);
        Aditional TresLeches = AditionalsFactory.create(EAditionals.TRESLECHES);
        //agregando prototipos
        PrototypeFactory.addPrototype("PostreDeManzana", PostreDeManzana);
        PrototypeFactory.addPrototype("Pudin", Pudin);
        PrototypeFactory.addPrototype("TresLeches", TresLeches);

        //creando algunos combos para pruebas
        /*
        * Usuario que pide un tec cheese básico
        * */
        Combo TecCheese = new Combo.ComboBuilder().setName(ECombo.TECCHEESE).setPrice(10)
                .addDrink(Drink.COKE).addSideDish(SideDish.FRIES).build();
        System.out.println("Precio usuario 1: "+TecCheese.getPrice());
        /*
         * Usuario que pide dos combos iguales de big tec cada uno con un postreDeManzana
         * */
        Combo BigTEC1 = new Combo.ComboBuilder().setName(ECombo.BIGTEC).setPrice(14)
                .addDrink(Drink.COKE).addSideDish(SideDish.FRIES)
                .addAditional((Aditional) PrototypeFactory.getPrototype("PostreDeManzana")).build();
        PrototypeFactory.addPrototype("BIGTEC1",BigTEC1);
        Combo BIGTEC2 = (Combo)PrototypeFactory.getPrototype("BIGTEC1");
        System.out.println("Precio usuario 2"+BigTEC1.getPrice() +" + "+BIGTEC2.getPrice());
        /*
         * ----------------Usuario usuario pide varios combos-----------------------
         * Combo 1: TECChicken($12)+ 2 acompañamientos adicionales ($5+$5) + 1 bebida adicional ($3) (sin postre)
         * Combo 2: TECFish($10) + postre manzana ($5) + pudin ($3)
         * Combo 3: Lo mismo que el combo 2 ($18)
         * Combo 4: Tec sandwich ($14)+  tres leches ($5)
         * */
        Combo TECChicken = new Combo.ComboBuilder().setName(ECombo.TECCHICKEN).setPrice(12)
                .addDrink(Drink.COKE).addDrink(Drink.FANTA)
                .addSideDish(SideDish.FRIES).addSideDish(SideDish.CARROT).addSideDish(SideDish.PUREE).build();

        Combo TECFish = new Combo.ComboBuilder().setName(TECFISH).setPrice(10)
                .addDrink(Drink.SPRITE).addSideDish(SideDish.FRIES)
                .addAditional((Aditional) PrototypeFactory.getPrototype("PostreDeManzana"))
                .addAditional((Aditional) PrototypeFactory.getPrototype("Pudin")).build();
        PrototypeFactory.addPrototype("tecfishpedido", TECFish);
        Combo TECFish2 = (Combo) PrototypeFactory.getPrototypeDeepCloned("tecfishpedido");

        Combo TECSandwich = new Combo.ComboBuilder().setName(ECombo.TECSANDWICH).setPrice(14)
                .addDrink(Drink.COKE).addSideDish(SideDish.FRIES)
                .addAditional((Aditional)PrototypeFactory.getPrototype("TresLeches")).build();
        //creando carrito
        ArrayList<Combo> cart = new ArrayList<>();
        //agregando
        cart.add(TECChicken);
        cart.add(TECFish);
        cart.add(TECFish2); //deepcloned
        cart.add(TECSandwich);
        int totalPrice = 0;


        //-------------------------------------------------------------------------




        System.out.println("Precio por combo");
        for (Combo item : cart){
            totalPrice += item.getPrice();
            System.out.println(item.getName().toString() +" = "+item.getPrice());
        }
        System.out.println("Total "+ totalPrice);




    }
}