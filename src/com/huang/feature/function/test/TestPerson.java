package com.huang.feature.function.test;

import com.huang.feature.function.Person;
import com.huang.feature.function.PersonFactory;

public class TestPerson
{
    // 创建一个Person构造函数的引用
    PersonFactory<Person> personFactory = Person :: new;
    //Person person = personFactory.create("Peter", "Parker");
    Person person = personFactory.create();
}
