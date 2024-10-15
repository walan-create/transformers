package org.iesvdm.transformer;


import java.util.ArrayList;

public class Joiners
{
    public static <T> LispList<T> zipLists(Joiner<T> joiner,LispList<T> ls1,LispList<T> ls2) {
        if(ls1.isEmpty()||ls2.isEmpty())
            return LispList.empty();
        else
        {
            T h = joiner.join(ls1.head(),ls2.head());
            LispList<T> t = zipLists(joiner,ls1.tail(),ls2.tail());
            return t.cons(h);
        }
    }

    //Metodo que toma dos ArrayList de T y los une siguiendo el parametro de union del Joiner
    public static <T> ArrayList<T> zipArrayList(Joiner<T> joiner, ArrayList<T> ls1, ArrayList<T> ls2){
        //Instanciamos lista a devolver
        ArrayList<T> result = new ArrayList<>();
        ArrayList<T> copy1 = new ArrayList<>(ls1);
        ArrayList<T> copy2 = new ArrayList<>(ls2);
        //Si alguna de las listas esta vacia devolvemos la lista vacia para que finalice la recursividad
        if (copy1.isEmpty()||copy2.isEmpty())
            return result;
        else
        {
            //Unimos el primer elemento de cada lista y lo añadimos a la lista de resultado
            T h = joiner.join(copy1.remove(0),copy2.remove(0));
            result.add(h);
            result.addAll(zipArrayList(joiner,copy1,copy2));
        }
        return result;
    }

    //Metodo que devuelve un solo resultado dependiendo de el tipo que sea T
    public static <T> T fold(Joiner<T> joiner,ArrayList<T> list){
        //creamos una copia para no actuar sobre la lista original
        ArrayList<T> copy = new ArrayList<>(list);
        /*Instanciamos el primer valor de la lista en un T pues si lo iniciamos como "null"
        nos va a dar problemas al usar el .join en el bucle. Por ejemplo null+1 o null+"Hola" da error*/
        T result = copy.getFirst();
        //Eliminamos el primer valor pues sino se suma 2 veces con el T result
        copy.remove(0);
        //Recorremos la lista copy y vamos sumando e instanciando los valores entre si
        for(T t : copy){
            result=joiner.join(result,t);
        }
        return result;
    }
}