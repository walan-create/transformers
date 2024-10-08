package org.iesvdm.transformer;

@FunctionalInterface
public interface Transformer<T> {

    public T transform(T obj);
}

