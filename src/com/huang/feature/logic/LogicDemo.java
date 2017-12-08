package com.huang.feature.logic;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LogicDemo
{
    @Test
    public void test()
    {
        //The old from before java 8
        List<String> list = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String string : list)
        {
            System.out.println(string);
        }
        
        System.out.println("---------------------------");
        
        //The new from before java 8
        list.forEach((n) -> System.out.println(n));
        
        System.out.println("---------------------------");
        
        //采用方法引用，不能对域内对象做修改才能使用这种方式
        list.forEach(System.out :: println);
    }
}
