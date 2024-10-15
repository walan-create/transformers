package org.iesvdm.transformer.ejercicio6;

import org.iesvdm.transformer.LispList;
import org.iesvdm.transformer.Transformers;

import java.util.Scanner;

public class MainEjercicio6Parte2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*----------------- Segunda implementación --------------------*/

        //Guardamos las palabras ingresadas en una Lista enlazada
        System.out.println("Introduce varias palabras separadas por espacios: ");
        String sentence1 = sc.nextLine();
        String[] sentences1  = sentence1.split(" ");
        LispList<String> lispList = LispList.empty();

        //Recorremos el array de Strins al reves para que al utilizar el encadenamiento
        //de LispList se guarden las palabras en el orden ingresado por el usuario
        for (int i = sentences1.length-1; i >= 0; i--){
            lispList=lispList.cons(sentences1[i]);
        }

        //Creamos la palabra a añadir
        System.out.println("Introduce una palabra para añadirla a las anteriores: ");
        String word1 = sc.nextLine();

        //Utilizamos el metodo creado en el ejercicio5 para transformar todos los valores de una lista enlazada
        LispList<String> modifiedLispList = Transformers.transformList(new WordAdder(word1),lispList);

        System.out.println("Tu lista: " + lispList);
        System.out.println("Tu palabra: " + word1);
        System.out.println("Tu lista: " + modifiedLispList);
    }
}
