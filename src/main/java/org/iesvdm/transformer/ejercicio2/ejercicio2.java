package org.iesvdm.transformer.ejercicio2;

import org.iesvdm.transformer.TenTimes;
import org.iesvdm.transformer.Transformer;
import org.iesvdm.transformer.Transformers;

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter some numbers (all on one line, separated by spaces):");
        String line = input.nextLine();
        String[] numbers = line.split(" ");
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0; i<numbers.length; i++)
            a.add(new Integer(numbers[i]));
        System.out.println("The numbers are stored in an ArrayList: "+a);
        Transformer<Integer> trans = new TenTimes();
        //Sustituimos el metodo applyConst por applyDest
        //ArrayList<Integer> b= Transformers.applyConst(trans,a);
        Transformers.applyDest(trans,a);
        System.out.println("We transform a and Multiplying the contents by 10 gives: "+a);
    }
}
