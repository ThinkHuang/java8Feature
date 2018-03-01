package com.huang.feature.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
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
    
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("java", "php", "mysql", "javascript");
        // filter,通过Predicate来对流中的数据进行过滤，属于中间操作
        //list.stream().filter((s) -> s.startsWith("j")).forEach(System.out :: println);
        
        // sorted,返回排序过的刘对象，属于中间操作。另外sorted不会改变原来集合中元素的顺序，它只是会返回一个排序后的集合视图，并且不可修改
        //list.stream().sorted().forEach(System.out :: println);
        
        //将流对象中的每个元素对应到另外一个对象上，按照现在的理解是，将key映射为value，其中映射的value可以使用泛型来指定，属于中间操作
        //list.stream().map(String :: toUpperCase).forEach(System.out :: println);
        
        //匹配操作多种不同的类型，使用规则在流对象中进行匹配，所有操作都是终结操作。只返回一个Boolean值
        //boolean anyStartsWithJ = list.stream().anyMatch((s) -> s.startsWith("j"));
        //boolean allStartsWithJ = list.stream().allMatch((s) -> s.startsWith("j"));
        //boolean noneStartsWithJ = list.stream().noneMatch((s) -> s.startsWith("j"));
        
        //count， 终结操作，返回流中的元素个数
       // long startWithJ = list.stream().count();
        
        // reduce是一个终结操作，对流中的元素进行削减，并返回一个Optional
       //Optional<String> reduced = list.stream().reduce((s1, s2) -> s1 + "#" + s2);
        //reduced.ifPresent(System.out :: println);
        
        /****************************************Parallel Streams***************************************************/
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < values.size(); i++)
        {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        
        //串行流
//        long s = System.nanoTime();
//        
//        long count = values.stream().sorted().count();
//        System.out.println(count);
//        
//        long e = System.nanoTime();
//        long millis = TimeUnit.NANOSECONDS.toMillis(e - s);
//        System.out.println(String.format("sequential sort took: %d ms", millis));
        
        //并行流
        long s = System.nanoTime();
        
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
         
        long e = System.nanoTime();
         
        long millis = TimeUnit.NANOSECONDS.toMillis(e - s);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }
}
