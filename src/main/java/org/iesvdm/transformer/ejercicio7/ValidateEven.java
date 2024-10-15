package org.iesvdm.transformer.ejercicio7;

public class ValidateEven implements Validator<Integer> {

    @Override
    public boolean check(Integer integer) {
        return integer%2==0;
    }
}
