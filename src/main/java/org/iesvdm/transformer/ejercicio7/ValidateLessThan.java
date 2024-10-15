package org.iesvdm.transformer.ejercicio7;

public class ValidateLessThan implements Validator<String> {

    int num;

    public ValidateLessThan(int n) {
        num=n;
    }

    @Override
    public boolean check(String s) {
        int length = s.length();
        return length < num;
    }
}
