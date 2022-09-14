package Adicional;

import Prototype.IPrototype;

public class TresLeches<T> extends Aditional implements IPrototype {
    public TresLeches(int price) {
        super(price);
    }
    @Override
    public T clone() {
        return null;
    };
    @Override
    public T deepClone(){
        return null;
    }

}
