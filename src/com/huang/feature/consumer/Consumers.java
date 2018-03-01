package com.huang.feature.consumer;

import java.util.function.Consumer;

import com.huang.feature.function.Person;

/**
 * 代表了在一个输入参数上需要进行的操作
 * @author huangyejun
 *
 */
public class Consumers
{
    public static void main(String[] args)
    {
        Consumer<Person> greeter = (p) -> System.out.println("hello" +  p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
    }
}
