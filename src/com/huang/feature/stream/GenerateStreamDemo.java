package com.huang.feature.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * 这一用例用来测试流的生成方式
 * @author huangyejun
 *         
 */
public class GenerateStreamDemo
{
    
    @Test
    public void test()
    {
        // 集合获取流
        List<String> list = Arrays.asList("java", "php", "mysql", "javascript");
        Stream<String> serialstream = list.stream();// 串行流
        Stream<String> parallelstream = list.parallelStream();// 并行流
        
        // 数组获取流
        String[] arr = new String[] {"java", "php", "mysql", "javascript"};
        Stream<String> arrstream = Arrays.stream(arr);
        
        //上面数组简化版
        Stream<String> stream = Stream.of("a", "b", "c");
        
        // BufferedReader获取流
        String path = "";
        Reader reader = null;
        BufferedReader breader = null;
        try
        {
            reader = new FileReader(new File(path));
            breader = new BufferedReader(reader);
            Stream<String> brstream = breader.lines();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (breader != null)
                try
                {
                    breader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            if (reader != null)
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }
    }
    
    //Stream下属的各种流对象产生（下面两种方式都不行）
//    java.util.stream.IntStream.range();
//    java.nio.file.Files.walk();
    
    //其他方式构建：
    //TODO:
    
    //注意当检测到构建的流类型为Integer，Long和Double时，可以使用IntStream，LongStream和DoubleStream。原因在于自动装箱和自动拆箱费时
}
