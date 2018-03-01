package com.huang.feature.function;

/**
 * 当使用@FunctionalInterface注解标注后，一个所谓的函数式接口必须要有且仅有一个抽象方法声明
 * 如果不标注的话，可以定义多个抽象方法声明
 * @author huangyejun
 *
 * @param <P>
 */
//@FunctionalInterface
public interface PersonFactory<P extends Person>
{
//    P create(String firstName, String lastName);
    
    P create();
}
