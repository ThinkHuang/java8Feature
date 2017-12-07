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
        //括号中的是形式参数，当参数只有一个时，可以使用括号，也可以不使用括号
        list.forEach((n) -> System.out.println(n));
        
        System.out.println("---------------------------");
        
        //使用方法引用::进行标识
        list.forEach(System.out :: println);
    }
}
