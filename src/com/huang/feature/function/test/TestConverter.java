package com.huang.feature.function.test;

import com.huang.feature.function.Converter;

/**
 * 函数式编程测试
 * @author huangyejun
 *
 */
public class TestConverter
{
    public static void main(String[] args)
    {
//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        //java8允许你通过::关键字获取方法或者构造函数的引用
        Converter<String, Integer> converter = Integer :: valueOf;
        
        Integer converted = converter.convert("123");
        System.out.println(converted);
        
    }
}
