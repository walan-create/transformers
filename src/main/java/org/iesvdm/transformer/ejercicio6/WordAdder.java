package org.iesvdm.transformer.ejercicio6;

import org.iesvdm.transformer.Transformer;

public class WordAdder implements Transformer<String> {

    String word;

    public WordAdder(String word) {
        this.word = word;
    }

    @Override
    public String transform(String add) {
        return add+" "+word;
    }

}
