package Adicional;

import Prototype.IPrototype;

public class PostreDeManzana extends Aditional {
    public PostreDeManzana(int price) {
        super(price);
    }

    @Override
    public PostreDeManzana clone() {
        PostreDeManzana clone = new PostreDeManzana(this.price);
        return clone;
    }

    @Override
    public PostreDeManzana deepClone() {

        return null;
    }
}
