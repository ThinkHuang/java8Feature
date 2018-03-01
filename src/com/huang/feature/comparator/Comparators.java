package com.huang.feature.comparator;

import java.util.Comparator;

import com.huang.feature.function.Person;

/**
 * 比较默认实现
 * @author huangyejun
 *
 */
public class Comparators
{
    public static void main(String[] args)
    {
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        
        comparator.compare(p1, p2);
        comparator.reversed().compare(p1, p2);
    }
}
