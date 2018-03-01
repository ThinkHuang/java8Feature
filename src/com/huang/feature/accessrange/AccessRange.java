package com.huang.feature.accessrange;

import com.huang.feature.function.Converter;

/**
 * 测试Lambda表达式的访问范围
 * @author huangyejun
 *
 */
public class AccessRange
{
    static int outerStaticNum;
    int outerNum;
    
    public static void main(String[] args)
    {
        //final int num = 1;
        //编译器默认将外部变量转成final
        int num = 1;
        Converter<Integer, String> converter = (from) -> String.valueOf(from + num);
        
        String converted = converter.convert(2);
        System.out.println(converted);
        
        
        //但是不允许在再修改外部变量的值
        //num = 3;
        //突然发现现在编译器的发展在规避人类的错误，会不会存在这么一天，编译器足够强大，然后完全代替人？？？？
        
        /**
         * 测试访问成员变量和静态变量
         */
        
        
    }
    
    void testScope() {
        Converter<Integer, String> converter = (from) -> {
          outerNum = 23;
          outerStaticNum = 72;
          return String.valueOf(from);
        };
    }
    
    /**
     * 在函数式编程中，默认方法无法在lambda表达式内部被访问
     */
}
