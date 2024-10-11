package org.iesvdm.transformer;

import java.util.Scanner;

public class UseJoiners1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // Declara tres listas de tipo LispList que contendrán enteros
        LispList<Integer> ls1, ls2, ls3;
        System.out.print("Enter a list (of integers): ");
        String str = in.nextLine();
        // Convierte la cadena ingresada en una lista de enteros
        ls1 = parseIntLispList(str);
        System.out.print("Enter another list (of integers): ");
        str = in.nextLine();
        // Convierte la segunda cadena ingresada en otra lista de enteros
        ls2 = parseIntLispList(str);
        // Crea un objeto Joiner que sumará los elementos correspondientes de las dos listas
        Joiner<Integer> adder = new JoinByAdding();
        // Combina las dos listas sumando los elementos correspondientes
        ls3 = Joiners.zipLists(adder, ls1, ls2);
        // Imprime la lista resultante de sumar los elementos que quedan despues de deshacernos del valor inicial y el final de la lista
        System.out.println("Adding corresponding integers in the lists gives:\n" + ls3);
    }

    // Método para convertir una cadena de texto en una lista de enteros
    public static LispList<Integer> parseIntLispList(String str) {
        // Elimina los espacios en blanco al principio y al final de la cadena
        String line = str.trim();
        // Crea una nueva cadena resultante de quitar el primer y el último carácter de la cadena por ejemplo si line:"1234" contents:"23"
        String contents = line.substring(1, line.length() - 1).trim();
        //Si la cadena está vacía, devuelve una lista vacía
        if (contents.length() == 0) return LispList.empty();
        // Divide la cadena en elementos individuales usando la coma como separador
        String[] nums = contents.split(",");
        LispList<Integer> list = LispList.empty();
        //Recorremos los elementos resultantes
        for (int i = nums.length - 1; i >= 0; i--) {
            // Elimina los espacios en blanco de cada elemento y lo convierte a entero
            String num = nums[i].trim();
            //Añade el entero a la lista
            list = list.cons(Integer.parseInt(num));
        }
        return list;
    }

}
