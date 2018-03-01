package com.huang.feature.predicate;

import java.util.Objects;
import java.util.function.Predicate;

public class Predicates
{
    public static void main(String[] args)
    {
        // 生成一个判断字符串长度是否大于0的谓词
        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println(predicate.test("foo"));
        //predicate.negate()返回该谓词的相反命题
        System.out.println(predicate.negate().test("foo"));
        
        Predicate<Boolean> nonNull = Objects :: nonNull;
        Predicate<Boolean> isNull = Objects :: isNull;
        
        Predicate<String> isEmpty = String :: isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }
}
