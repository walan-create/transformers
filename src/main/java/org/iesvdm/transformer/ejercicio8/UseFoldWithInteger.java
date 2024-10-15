package org.iesvdm.transformer.ejercicio8;

import org.iesvdm.transformer.JoinByAdding;
import org.iesvdm.transformer.Joiner;
import org.iesvdm.transformer.Joiners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UseFoldWithInteger {
    public static void main(String[] args) {

        Scanner sc2 = new Scanner(System.in);
        //Pedimos los numeros con los que actuar
        System.out.println("Escribe varios numeros separados por espacios");
        String ints = sc2.nextLine();
        String[] stringsArray = ints.split(" ");
        //Pasamos el Array a Lista
        ArrayList<String> stringsList = new ArrayList<>(Arrays.asList(stringsArray));
        //Hacemos un stream que nos convierte todos las cadenas de la primera lista y las agrega en una lista como entero
        ArrayList<Integer> integerList = stringsList.stream().map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        //Creamos el joiner que suma todos los integers, usamos el metodo fold e imprimimos el resultado.
        Joiner<Integer> joiner = new JoinByAdding();
        Integer suma= Joiners.fold(joiner,integerList);
        System.out.println("La unión de toda la lista es: "+suma);

    }
}
