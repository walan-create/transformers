package org.iesvdm.transformer.ejercicio8;

import org.iesvdm.transformer.Joiner;

public class JoinerWords implements Joiner<String> {
    @Override
    public String join(String obj1, String obj2) {
        //Lamamos a .trim() para asegurarnos de que no hayan espacios indeseados
        return obj1.trim()+" "+obj2.trim();
    }
}
