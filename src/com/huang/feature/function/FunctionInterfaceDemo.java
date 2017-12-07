package com.huang.feature.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * ����ʽ�ӿڱ��
 * @author huangyejun
 *         
 */
public class FunctionInterfaceDemo
{
    @Test
    public void test()
    {
        
        List<String> list = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "Jsp");
//        filter(list, (str) -> str.startsWith("J"));

//        System.out.println("print all languages:");
//        filter(list, (str) -> true);// �Ҳ²���˼����str��Ϊ��

//        System.out.println("print no language:");
//        filter(list, (str) -> false);

//        System.out.println("print language whose length is greater than 4");
//        filter(list, (str) -> str.length() > 4);
        
        System.out.println("-----------------------------");
        // ͬʱ��ʾ���ַ���J��ͷ�����ҳ��ȴ��ڵ���4
        Predicate<String> startsWithJ = (str) -> str.startsWith("J");
        Predicate<String> gt4 = (str) -> str.length() == 4;
        // ��ʼ��������ʽ��predicate����
        list.stream().filter(startsWithJ.and(gt4));//������Ϊʲô��仰û�д�ӡ����
        list.stream().filter(startsWithJ.and(gt4)).forEach(n -> System.out.println("nName, which starts with 'J' and four letter long is : " + n));
        
    }
    
    // �������Է��֣������Predicate�ϲ����뷺�͵Ļ��������ĵ��þͲ���ͨ���������ļ��
    public void filter(List<String> names, Predicate<String> condition)
    {
        for (String name : names)
        {
            if (condition.test(name))
            {
                System.out.println(name + " ");
            }
        }
    }
    
}
