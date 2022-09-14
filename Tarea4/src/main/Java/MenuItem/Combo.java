package MenuItem;

import Prototype.IPrototype;
import enums.Drink;
import enums.ECombo;
import enums.SideDish;
import Adicional.Aditional;

import java.util.ArrayList;


public class Combo implements IPrototype<Combo>{
    private ECombo name;
    private int price;
    private ArrayList<Drink> extraDrinks;
    private ArrayList<SideDish> extraSideDishes;
    private ArrayList<Aditional> aditionals;
    
    public Combo(ECombo name, int price, ArrayList<Drink> extraDrinks, ArrayList<SideDish> extraSideDishes, ArrayList<Aditional> aditionals){
        this.name = name;
        this.price = price;
        this.extraDrinks = extraDrinks;
        this.extraSideDishes = extraSideDishes;
        this.aditionals = aditionals;
    }

    public int calculateExtraDrinks(){
        return this.extraDrinks.size() * 3;
    }

    public int calculateExtraSideDishes(){
        return this.extraSideDishes.size() * 5;
    }






    @Override
    public Combo clone() {
        Combo clone = new Combo(this.name, this.price, this.extraDrinks, this.extraSideDishes , this.aditionals);


        return clone;
    }

    public void setName(ECombo name) {
        this.name = name;
    }

    public void setExtraDrinks(ArrayList<Drink> extraDrinks) {
        this.extraDrinks = extraDrinks;
    }

    public void setExtraSideDishes(ArrayList<SideDish> extraSideDishes) {
        this.extraSideDishes = extraSideDishes;
    }

    public void setAditionals(ArrayList<Aditional> aditionals) {
        this.aditionals = aditionals;
    }

    public ECombo getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public Combo deepClone() {
        Combo deepcloned = new Combo.ComboBuilder().setName(this.name).setPrice(this.price).build();
        ArrayList<Drink> extraDrinks = new ArrayList<>();
        ArrayList<SideDish> extraSideDishes = new ArrayList<>();
        ArrayList<Aditional> aditionals = new ArrayList<>();

        for(Drink extraDrink : this.extraDrinks){
            extraDrinks.add(extraDrink);
        }
        for(SideDish extraSideDish : this.extraSideDishes){
            extraSideDishes.add(extraSideDish);
        }
        for(Aditional oneAdicional : this.aditionals){
            aditionals.add(oneAdicional.clone());
        }
        deepcloned.setExtraDrinks(extraDrinks);
        deepcloned.setExtraSideDishes(extraSideDishes);
        deepcloned.setAditionals(aditionals);
        return deepcloned;
    }


    public static class ComboBuilder{
        private ECombo name;
        private int price;
        private ArrayList<Drink> extraDrinks = new ArrayList<>();
        private ArrayList<SideDish> extraSideDishes = new ArrayList<>();
        private ArrayList<Aditional> aditionals = new ArrayList<>();

        public ComboBuilder(){

        }
        public ComboBuilder setName(ECombo tag){
            this.name = tag;
            return this;
        }

        public ComboBuilder setPrice(int price){
            this.price = price;
            return this;
        }

        public ComboBuilder addDrink(Drink bebida){
            if(this.extraDrinks.size()>0){ //la primer bebida es gratis, si no es vacio entonces se cobra
                this.price+=3;
            }
            this.extraDrinks.add(bebida);
          
            return this;
        }

        public ComboBuilder addSideDish(SideDish platillo){
            if(this.extraSideDishes.size()>0){
                this.price+=5;
            }
            this.extraSideDishes.add(platillo);

            return this;
        }

        public ComboBuilder addAditional(Aditional adicional){
            this.aditionals.add(adicional);
            this.price+=adicional.price; //los postres no están incluidos, por lo tanto siempre se cobran
            return this;
        }

        public Combo build() {
            return new Combo(this.name, this.price, this.extraDrinks, this.extraSideDishes, this.aditionals);
        }
    }
}

//class PrototypeFactory{
//    ArrayList<IPrototype> = new ArrayList<>();
//    <MenuItem('BigTec', 5), MenuItem('TecCheese', 5), MenuItem('BigTec', 5), MenuItem('BigTec', 5), MenuItem('BigTec', 5)>
//
//    getItem(qty, type){
//
//    }
//}
