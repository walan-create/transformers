package org.iesvdm.transformer.ejercicio6;

import org.iesvdm.transformer.LispList;
import org.iesvdm.transformer.Transformer;
import org.iesvdm.transformer.Transformers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainEjercicio6parte1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*----------------- Primera implementación --------------------*/

        //Guardamos las palabras ingresadas en una Lista
        System.out.println("Introduce varias palabras separadas por espacios: ");
        String sentence = sc.nextLine();
        String[] sentences  = sentence.split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(sentences));

        //Creamos la palabra a añadir
        System.out.println("Introduce una palabra para añadirla a las anteriores: ");
        String word = sc.nextLine();

        //Creamos el transformer WordAdder que hemos hecho
        Transformer<String> trans= new WordAdder(word);

        //Creamos una lista con las palabras modificadas
        ArrayList<String> modifiedList = Transformers.applyConst(trans,list);
        System.out.println("Tu lista: " + list);
        System.out.println("Tu palabra: " + word);
        System.out.println("Tu lista: " + modifiedList);

    }
}
