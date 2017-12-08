package com.huang.feature.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * 函数式接口编程
 * @author huangyejun
 *         
 */
public class FunctionInterfaceDemo
{
    @Test
    public void test()
    {
        
        List<String> list = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "Jsp");
//        filter(list, (str) -> str.startsWith("J"));

//        System.out.println("print all languages:");
//        filter(list, (str) -> true);// 

//        System.out.println("print no language:");
//        filter(list, (str) -> false);

//        System.out.println("print language whose length is greater than 4");
//        filter(list, (str) -> str.length() > 4);
        
        System.out.println("-----------------------------");
        //使用组合模式构建Predicate流程
        Predicate<String> startsWithJ = (str) -> str.startsWith("J");
        Predicate<String> gt4 = (str) -> str.length() == 4;
        // 获取集合流后将Predicate加入
        list.stream().filter(startsWithJ.and(gt4));//这种方式为什么没有进行打印？因为stream本身包含一个filter方法，不在走下面定义的filter方法了
        list.stream().filter(startsWithJ.and(gt4)).forEach(n -> System.out.println("nName, which starts with 'J' and four letter long is : " + n));
        
    }
    
    // 通过测试，发现Predicate如果不加入泛型，将会导致编译不通过
    public void filter(List<String> names, Predicate<String> condition)
    {
        for (String name : names)
        {
            if (condition.test(name))
            {
                System.out.println(name + " ");
            }
        }
    }
    
}
