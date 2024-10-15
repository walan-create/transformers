package org.iesvdm.transformer.ejercicio8;

import org.iesvdm.transformer.Joiner;
import org.iesvdm.transformer.Joiners;

import java.util.ArrayList;
import java.util.Scanner;

public class UseFoldWithString {
    public static void main(String[] args) {

        //Pedimos 3 palabras
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la primera palabra");
        String palabra = sc.nextLine();
        System.out.println("Escribe la segunda palabra");
        String palabra2 = sc.nextLine();
        System.out.println("Escribe la tercera palabra");
        String palabra3 = sc.nextLine();

        //Las agrupamos en una Lista
        ArrayList<String> palabras = new ArrayList<>();
        palabras.add(palabra);
        palabras.add(palabra2);
        palabras.add(palabra3);

        //Las unimos mediante el metodo fold y el JoinerWords y mostramos por pantalla
        Joiner<String> joiner = new JoinerWords();
        String palabrasUnidas=Joiners.fold(joiner,palabras);
        System.out.println("Las palabras unidas son: "+palabrasUnidas);
    }
}
