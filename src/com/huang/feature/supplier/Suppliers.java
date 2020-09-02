package com.huang.feature.supplier;

import java.util.function.Supplier;

import com.huang.feature.function.Person;

/**
 * 没有参数，返回一个指定类型的结果
 * @author huangyejun
 *
 */
public class Suppliers
{
    public static void main(String[] args)
    {
        Supplier<Person> supplier = Person :: new;
        Person person = supplier.get();
        
        Supplier<Runnable> c = () -> () -> {System.out.println("hi");};
        c.get().run();
        
        Object o = (Runnable)() -> {System.out.println("hi");};
    }
}
