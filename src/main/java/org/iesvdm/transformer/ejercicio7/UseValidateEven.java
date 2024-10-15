package org.iesvdm.transformer.ejercicio7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UseValidateEven {
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
        //Creamos el validador de numero pares
        Validator<Integer> validatorInteger=new ValidateEven();

        System.out.println("-----------------------");
        System.out.println("Lista original: "+integerList);
        //Filtramos la lista original y la imprimimos
        Validators.FilterBy(validatorInteger,integerList);
        System.out.println("Filtramos los numeros que sean pares");
        System.out.println("Lista filtrada: "+integerList);
        System.out.println("-----------------------");
    }
}
