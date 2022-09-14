package Adicional;

import Prototype.IPrototype;

public class TresLeches extends Aditional  {
    public TresLeches(int price) {
        super(price);
    }
    @Override
    public TresLeches clone() {
        return new TresLeches(this.price);
    };
    @Override
    public TresLeches deepClone(){
        return null;
    }

}
