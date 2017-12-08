package com.huang.feature.anonymous;

import org.junit.Test;

public class AnonymousDemo
{
    /*
     * 在使用lambda表达式代替匿名类时，确定其差一点很有必要
     * 区别为：匿名类的this指向的是匿名类本身，而lambda的this指向的是包围lambda表达式的类
     * lambda表达式被生成一个私有的静态方法，方法名称形如"lambda$0()，通过JVM调用invokedynamic在运行期动态绑定到方法上面"
     */
    
    @Test
    public void testWithoutParams(){
        
        //The old from before java 8
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("the old from before java 8");
            }
        }).start();
        
        //The new from after java 8
        //以下两种方式都可行
        new Thread(() -> {System.out.println("the new from after java 8");}).start();
        new Thread(() -> System.out.println("the new from after java 8")).start();
        
    }
    
    @Test
    public void testWithParams(){
      //TODO:参见后面的例子
        
    }
    

}
