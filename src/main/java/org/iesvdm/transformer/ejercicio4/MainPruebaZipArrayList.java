package org.iesvdm.transformer.ejercicio4;

import org.iesvdm.transformer.JoinByAdding;
import org.iesvdm.transformer.Joiner;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPruebaZipArrayList {
    public static void main(String[] args) {
        //----------------------------------------------
        //Pedimos al usuario 2 listas y las convertimos de una cadena String a un ArrayList de enteros
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce una lista de enteros separados por coma");
        String str = in.nextLine();
        ArrayList<Integer> ls1 = parseIntArrayList(str);
        System.out.println("Introduce otra lista de enteros separados por coma");
        str = in.nextLine();
        ArrayList<Integer> ls2 = parseIntArrayList(str);
        //----------------------------------------------
        //Creamos un Joiner que sume los enteros
        Joiner<Integer> adder = new JoinByAdding();
        //Unimos las listas según los criterios del Joiner
        ArrayList<Integer> result = org.iesvdm.transformer.Joiners.zipArrayList(adder, ls1, ls2);
        //----------------------------------------------
        System.out.println("----------------------");
        System.out.println("Lista 1: "+ls1);
        System.out.println("Lista 2: "+ls2);
        System.out.println("Resultado de sumar las listas: "+result);
        System.out.println("----------------------");
    }

    private static ArrayList<Integer> parseIntArrayList(String str) {
        String line = str.trim();
        String[] nums = line.split(",");
        if (nums.length == 0) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            String num = nums[i].trim();
            list.add(Integer.parseInt(num));
        }
        return list;
    }
}
