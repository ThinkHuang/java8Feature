package com.huang.feature.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MethodReference
{
    
    @Test
    public void function1()
    {
        List<String> resource = Arrays.asList("Windows", "Mac OSX");
        // 静态方法引用
        // before
         resource.forEach(x -> System.out.println(x));
        // after
         resource.forEach(System.out::println);
        
        // 实例方法引用
        // String target = "Windows";
        // System.out.print(resource.parallelStream().anyMatch(target::equals));
        
        // 引用String类的实例方法
        // String target = "Hello";
        // FunctionInterface inter = target::concat;
        // System.out.print(inter.transfer(" World"));
        
        // 构造方法引用
        // ConstructorInterface constr = Target::new;
        // Target t = constr.create(1);
        // System.out.print(t.attr);
        
        // 数组的构造函数
        // ArrayInterface arrstr = int[]::new;
        // int[] array = arrstr.create(10);
        // System.out.println(array.length);
        
        // 实例对象方法静态引用
        // Target t1 = new Target(10);
        // Target t2 = new Target(100);
        
        // InstanceFunctionInterface ins1 = Target::compareTo;
        // int result = ins1.compare(t1, t2);
        // System.out.println(result);
        
        //InstanceFunctionInterface ins2 = Target::compare;
        // int rs = ins2.compare(t1, t2);
        
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("c", "2017-01-01"));
        persons.add(new Person("b", "2016-01-01"));
        persons.add(new Person("a", "2015-01-01"));
        
        Collections.sort(persons, Comparator.comparing(Person::getBirthday));
    }
    
}

