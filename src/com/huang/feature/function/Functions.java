package com.huang.feature.function;

import java.util.function.Function;

/**
 * 接收单一的参数，并返回单一的结果
 * @author huangyejun
 *
 */
public class Functions
{
    public static void main(String[] args)
    {
        Function<String, Integer> toInteger = Integer :: valueOf;
        Function<String, Object> toString = toInteger.andThen(String :: valueOf);
        System.out.println(toString.apply("123456"));
    }
}
