package org.iesvdm.transformer;

public class JoinByAdding implements Joiner<Integer>
{

    public Integer join(Integer int1,Integer int2)
    {
        return int1+int2;
    }
}
