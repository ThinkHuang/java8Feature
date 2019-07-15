package com.huang.feature.targettype;

import java.io.FileFilter;
import java.security.PrivilegedAction;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 尝试使用lambda表达式的各种写法，验证目录类型lambda自动推断
 * T 是一个函数式接口
 * lambda 表达式的参数和 T 的方法参数在数量和类型上一一对应
 * lambda 表达式的返回值和 T 的方法返回值相兼容（Compatible）
 * lambda 表达式内所抛出的异常和 T 的方法 throws 类型相兼容
 * 
 * @author Administrator
 *
 */
public class TargetType
{
    
    @Test
    public void test()
    {
        Callable<String> c = () -> "done";
        
        PrivilegedAction<String> action = () -> "done";
        
        Comparator<String> comparator = (s1, s2) -> s1.compareToIgnoreCase(s2);
        
        FileFilter file = f -> f.getName().endsWith("java");
        
        Supplier<Runnable> s = () -> () -> {System.out.println("hi");};
        
        boolean flag = true;
        Callable<Integer> i = flag ? (() -> 23) : (() -> 42);
    }
    
}
