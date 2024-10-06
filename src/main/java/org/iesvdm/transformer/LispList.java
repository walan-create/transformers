package org.iesvdm.transformer;

public class LispList<E>
{
    private Cell<E> myList;

    private LispList(Cell<E> list)
    {
        myList=list;
    }

    public boolean isEmpty()
    {
        return myList==null;
    }

    public E head()
    {
        return myList.first;
    }

    public LispList<E> tail()
    {
        return new LispList<E>(myList.rest);
    }

    public LispList<E> cons(E item)
    {
        return new LispList<E>(new Cell<E>(item,myList));
    }

    public static <T> LispList<T> empty()
    {
        return new LispList<T>(null);
    }

    public boolean equals(Object other)
    {
        LispList<E> otherList = (LispList<E>) other;
        if(this.isEmpty())
            return otherList.isEmpty();
        else
            return this.head().equals(otherList.head()) &&
                    this.tail().equals(otherList.tail());
    }

    public String toString()
    {
        if(isEmpty())
            return "[]";
        else
            return "["+head()+restToString(tail());
    }

    private static <T> String restToString(LispList<T> l)
    {
        if(l.isEmpty())
            return "]";
        else
            return ","+l.head()+restToString(l.tail());
    }

    private static class Cell <T>
    {
        T first;
        Cell<T> rest;

        Cell(T h,Cell<T> t)
        {
            first=h;
            rest=t;
        }
    }

}
