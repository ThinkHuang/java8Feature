package com.huang.feature.comparator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;

import org.junit.Test;

public class ComparatorDemo
{
    @Test
    public void test()
    {
        // The old from before java 8
        JButton show = new JButton("show");
        show.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Event handling without lambda express is boring");
            }
        });
        
        // The new from after java 8
        show.addActionListener((e) -> {
            System.out.println("Event handling with lambda express is exciting");
        });
    }
    
    @Test
    public void extendComparator(){
        //The old from before java 8
        List<String> list = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        Collections.sort(list, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return 0;
            }
        });
        
        //The new from after java 8
        Collections.sort(list, (String str1, String str2) -> str1.compareTo(str2));
        List<Integer> intList = Arrays.asList(111,222,333,444);
        Collections.sort(intList, (Integer i, Integer j) -> i.compareTo(j));
        
        //由上可知，只要实现了Comparable接口都可以使用这种方式
        
    }
}
