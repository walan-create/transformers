package org.iesvdm.transformer.ejercicio7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UseValidateLessThan {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    //Pedimos y pasamos cadenas de palabras a una lista de Strings
    System.out.println("Escribe varias palabras separadas por espacios");
    String words = sc.nextLine();
    String[] wordsArray = words.split(" ");
    ArrayList<String> list = new ArrayList<>(Arrays.asList(wordsArray));

    //Pedimos un numero y creamos el validador en base a ese numero
    System.out.println("Dame un numero para filtrar");
    int n=sc.nextInt();
    Validator<String> validator = new ValidateLessThan(n);

    System.out.println("-----------------------");
    System.out.println("Lista original: "+list);
    //Filtramos la lista original y la imprimimos
    Validators.FilterBy(validator,list);
    System.out.println("Filtramos las palabras con "+n+" letras o mas");
    System.out.println("Lista filtrada: "+list);
    System.out.println("-----------------------\n");

    }
}
