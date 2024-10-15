package org.iesvdm.transformer;

import java.util.*;

public class UseTransformers3
{
    public static void main(String[] args) throws Exception
    {
        //Guardamos los numeros dados en una lista de enteros
        Scanner input = new Scanner(System.in);
        System.out.println("Enter some numbers (all on one line, separated by spaces):");
        String line = input.nextLine();
        String[] numbers = line.split(" ");
        ArrayList<Integer> a = new ArrayList<Integer>();
        //Recorremos el array de numeros y los guardamos en la lista
        for(int i=0; i<numbers.length; i++)
            a.add(Integer.valueOf(numbers[i]));

        //Mostramos los numeros guardados en la lista
        System.out.println("The numbers are stored in an ArrayList: "+a);

        //Pedimos un numero entero al usuario
        System.out.print("Enter an integer: ");
        int m = input.nextInt();

        //Creamos un Transformer que multiplica por el numero ingresado por el usuario
        Transformer<Integer> multByM = new Multiplier(m);
        //Creamos una segunda lista de enteros que transforma los elementos de la primera lista y los multiplica por m
        ArrayList<Integer> b=Transformers.applyConst(multByM,a);
        System.out.println("Multiplying the contents by "+m+" gives: "+b);
    }

}
