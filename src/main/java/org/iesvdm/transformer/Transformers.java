package org.iesvdm.transformer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Transformers
{
    public static <T> ArrayList<T> applyConst(Transformer<T> tran, ArrayList<T> inicial) {

        ArrayList<T> devolver = new ArrayList<>();
        for(T t : inicial)
            devolver.add(tran.transform(t));
        return devolver;
    }

    public static <T> void applyDest(Transformer<T> tran, ArrayList<T> inicial){
        ArrayList<T> finale = applyConst(tran, inicial);
        inicial.clear();
        inicial.addAll(finale);
    }

    public static <T> LispList<T> transformList(Transformer<T> trans, LispList<T> listaDada){
       if (listaDada.isEmpty()){
           return LispList.empty();
       }
       T head = trans.transform(listaDada.head());
       LispList<T> tail = Transformers.transformList(trans, listaDada.tail());
       return tail.cons(head);
    }
}

