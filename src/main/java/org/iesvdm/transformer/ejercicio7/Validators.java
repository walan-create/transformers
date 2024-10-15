package org.iesvdm.transformer.ejercicio7;

import java.util.ArrayList;
import java.util.Iterator;

public class Validators {

    public static <T> void FilterBy(Validator<T> validator, ArrayList<T> list) {
//        list.removeIf(t -> !validator.check(t)); Esto serviría tambien, es con un lambda
        Iterator<T> iterator = list.iterator();
        //Recorremos la lista y filtramos
        while (iterator.hasNext()) {
            T next = iterator.next();
            //Si la expresion no se cumple se elimina de la lista
            if(!validator.check(next)) {
                iterator.remove();
            }
        }
    };


}
