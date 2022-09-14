package Adicional;

import Prototype.IPrototype;

public class PostreDeManzana<T> extends Aditional implements IPrototype {
    public PostreDeManzana(int price) {
        super(price);
    }

    @Override
    public T clone() {
        return null;
    }

    @Override
    public T deepClone() {
        return null;
    }
}
