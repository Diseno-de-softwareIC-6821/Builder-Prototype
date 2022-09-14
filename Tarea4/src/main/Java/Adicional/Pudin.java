package Adicional;

import Prototype.IPrototype;

public class Pudin extends Aditional{
    public Pudin(int price) {

        super(price);
    }

    @Override
    public Pudin clone() {

        return new Pudin(this.price);
    }

    @Override
    public Pudin deepClone() {
        return null;
    }
}
