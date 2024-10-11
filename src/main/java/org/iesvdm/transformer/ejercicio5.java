package org.iesvdm.transformer;

public class ejercicio5 {

    public static void main(String[] args) {
        LispList<Integer> integerList = new LispList<Integer>(
                new LispList.Cell<>(
                1, new LispList.Cell<>(
                2, new LispList.Cell<>(
                3, new LispList.Cell<>(
                4, new LispList.Cell<>(
                5, null))))));
        LispList<Integer> l1= LispList.empty();
        Transformer<Integer> transIntegersX2 = (Integer) -> Integer * 2;
        LispList<Integer> integerListx2 = Transformers.transformList(transIntegersX2, integerList);
        System.out.println("LispList de enteros: "+integerList);
        System.out.println("Lisplist de enteros x2: "+integerListx2);

        //Explicacion de Jose Manuel de como iterar una lista enlazada
        /*for(int i=0; i<2; i++){
            l2 = l2.tail();
        };
        System.out.println(l2.head());*/
    }
}
