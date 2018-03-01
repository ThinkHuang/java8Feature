package com.huang.feature.function.test;

import com.huang.feature.function.Converter;
import com.huang.feature.function.Something;

public class TestSomething
{
    public static void main(String[] args)
    {
        Something some = new Something();
        Converter<String, String> converter = some :: startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);
    }
}
