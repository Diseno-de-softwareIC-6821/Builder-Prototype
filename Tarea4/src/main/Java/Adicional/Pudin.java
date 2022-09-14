package Adicional;

import Prototype.IPrototype;

public class Pudin<T> extends Aditional implements IPrototype {
    public Pudin(int price) {
        super(price);
    }

    @Override
    public T clone() {
        return null;
    }

    @Override
    public Object deepClone() {
        return null;
    }
}
