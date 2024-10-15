package org.iesvdm.transformer.ejercicio7;

@FunctionalInterface
public interface Validator<T> {
    public boolean check(T t);
}
