package Adicional;

import Prototype.IPrototype;

public abstract class Aditional implements IPrototype<Aditional>{
    public int price;

    public Aditional(int price) {
        this.price = price;
    }

    @Override
    public abstract Aditional clone();
    @Override
    public abstract Aditional deepClone();


}
