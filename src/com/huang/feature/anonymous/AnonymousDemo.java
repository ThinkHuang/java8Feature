package com.huang.feature.anonymous;

import org.junit.Test;

public class AnonymousDemo
{
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
        //下面两种形式是一样的
        new Thread(() -> {System.out.println("the new from after java 8");}).start();
        new Thread(() -> System.out.println("the new from after java 8")).start();
        
    }
    
    @Test
    public void testWithParams(){
      //TODO:
        
    }
    

}
