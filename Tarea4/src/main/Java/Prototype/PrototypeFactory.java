package Prototype;

import java.util.HashMap;

public class PrototypeFactory {
    private static  HashMap<String, IPrototype> prototypes = new HashMap<>();

    public static IPrototype getPrototype(String prototypeName){
        return prototypes.get(prototypeName).clone();
    }
    public static IPrototype getPrototypeDeepCloned(String prototypeName){
        return prototypes.get(prototypeName).deepClone();
    }


    public static void addPrototype(String prototypeName, IPrototype prototype){
        prototypes.put(prototypeName, prototype);
    }
}

