package com.huang.feature.collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class CollectionDemo
{
    @Test
    public void test()
    {
        // The old from before java 8
        List<Integer> list = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer i : list)
        {
            double price = i * 0.12;
            System.out.println(price);
        }
        
        System.out.println("-----------------------------");
        
        // The new from after java 8
        // 从上面可以看出，使用lambda表达式就是重新定义"行为"
        list.stream().map(n -> n * 0.12).forEach(System.out::println);
    }
    
    // 利用reduce对集合进行整合
    @Test
    public void test1()
    {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0.0;
        // The old from before java 8
        for (Integer o : costBeforeTax)
        {
            double price = o + o * 0.12;
            total += price;
        }
        System.out.println("total : " + total);
        
        // The new from after java 8
        double bill = costBeforeTax.stream().mapToDouble((o) -> o + o * 0.12).reduce((sum, o) -> sum + o).getAsDouble();
        System.out.println("bill:" + bill);
    }
    
    // 对集合中的每个元素应用函数
    @Test
    public void test2()
    {
        List<String> list = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String result = list.stream().map(str -> str.toUpperCase()).collect(Collectors.joining(""));
        System.out.println(result);
    }
    
    //使用流的distinct方法对集合进行去重操作
    @Test
    public void test3()
    {
        List<Integer> list = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        Stream<Integer> stream = list.stream().map((i) -> i *i).distinct();
        List<Integer> distinct = stream.collect(Collectors.toList());
        
        System.out.printf("the origin list %s, the distincted list %s", list, distinct);
    }
    
    //计算集合的总数，平均数等
    @Test
    public void test4()
    {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics statistics = primes.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("总数为：" + statistics.getSum());
        System.out.println("平均数为：" + statistics.getAverage());
        System.out.println("最大数为：" + statistics.getMax());
        System.out.println("最小为：" + statistics.getMin());
    }
    
    //使用flatmap整合多个集合的结果
    @Test
    public void test5(){
        Stream<List<Integer>> inputstream = Stream.of(
            Arrays.asList(1),
            Arrays.asList(2, 3),
            Arrays.asList(4, 5, 6)
        );
        
        Stream<Integer> outstream = inputstream.flatMap(childlist -> childlist.stream());
        System.out.printf("outstream : %s", outstream.collect(Collectors.toList()));
    }
    
    //获取数组中的偶数位置上的数据重新组成新的数组
    @Test
    public void filter(){
        Integer[] nums = {1, 2, 3, 4, 5, 6};
        Stream<Integer> stream = Arrays.stream(nums);
        Integer[] newnums = stream.filter(index -> index % 2 == 0).toArray(Integer[] :: new);
        Stream.of(newnums).forEach(System.out :: println);
    }
    
    //使用reader.lines()，通过指定的过滤字段，将文本中的字符“挑拣”出来形成流后放到数组中去
    @Test
    public void test6() throws FileNotFoundException{
        String path = "";//文件路径
        String REGEXP = " ";//默认为空格
        //由于没有对流进行关闭操作，导致下面会抛出warning
        @SuppressWarnings("resource")
        Stream<String> stream = new BufferedReader(new FileReader(new File(path))).lines();
        stream.flatMap(line -> Stream.of(line.split(REGEXP))).
        filter(o -> o.length() > 0).
        collect(Collectors.toList());
    }
}
