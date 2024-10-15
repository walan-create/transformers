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

    public static <T> T fold(Joiner<T> joiner,ArrayList<T> list){
        ArrayList<T> copy = new ArrayList<>(list);
        T result = copy.getFirst();
        copy.remove(0);
        for(T t : copy){
            result=joiner.join(result,t);
        }
        return result;
    }
}