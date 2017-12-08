package com.huang.feature.logic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

public class FilterStringDemo
{
    @Test
    public void test()
    {
        List<String> originList = Arrays.asList("abc", "bcd" , "defg ", "jk");
        Predicate<String> predicate = (n) -> n.length() > 2 ;
        List<String> filterList = originList.stream().filter(predicate).collect(Collectors.toList());
        System.out.printf("the original list: %s , filter list %s %n", originList, filterList);
    }
}
