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
//        filter(list, (str) -> true);// 我猜测意思就是str不为空

//        System.out.println("print no language:");
//        filter(list, (str) -> false);

//        System.out.println("print language whose length is greater than 4");
//        filter(list, (str) -> str.length() > 4);
        
        System.out.println("-----------------------------");
        // 同时表示该字符以J开头，并且长度大于等于4
        Predicate<String> startsWithJ = (str) -> str.startsWith("J");
        Predicate<String> gt4 = (str) -> str.length() == 4;
        // 开始以流的形式将predicate加入
        list.stream().filter(startsWithJ.and(gt4));//？？？为什么这句话没有打印出来
        list.stream().filter(startsWithJ.and(gt4)).forEach(n -> System.out.println("nName, which starts with 'J' and four letter long is : " + n));
        
    }
    
    // 经过测试发现，如果在Predicate上不加入泛型的话，上述的调用就不会通过编译器的检查
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
