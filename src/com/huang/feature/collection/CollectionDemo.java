package com.huang.feature.collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArraySet;
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
        double bill = costBeforeTax.stream().mapToDouble(o -> o + o * 0.12).reduce((sum, o) -> sum + o).getAsDouble();
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
//        Stream<Integer> stream = list.stream().map(i -> i * i).distinct();
        Stream<Integer> stream = list.stream().distinct();
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
        // toArray()是终止流状态的操作，隐藏，该操作在执行完之后不能重新再对流进行操作。
        System.out.printf("after outstream : %s", inputstream.toArray());
//        Stream<Integer> outstream = inputstream.flatMap(childlist -> childlist.stream());
//        System.out.printf("outstream : %s", outstream.collect(Collectors.toList()));
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
    
    @Test
    public void test7() {
        List<String> list = Arrays.asList("peter", "anna", "mike", "xenia");
        
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }
        });
        
        Collections.sort(list, (String a, String b) -> {
            return a.compareTo(b);
        });
        
        Collections.sort(list, (a, b) -> a.compareTo(b));
    }
    
    @Test
    public void test8() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++)
        {
            map.putIfAbsent(i, "val" + i);
        }
        //map.forEach((id, val) -> System.out.println(id + ":" + val));
        
        map.computeIfPresent(3, (num, val) -> val + num);
        //System.out.println(map.get(3));
        
        map.computeIfPresent(9, (num, val) -> null);
        //System.out.println(map.get(9));
        
        map.computeIfAbsent(23, num -> "val" + num);
        //System.out.println(map.get(23));
        
        map.computeIfAbsent(3, num -> "bam");
        //System.out.println(map.get(3));
        
        map.remove(3, "val3");
       // System.out.println(map.get(3));
        
        map.remove(3, "val33");//要移除的对象是给定的value时才移除
        //System.out.println(map.get(3));
        
        //合并操作先看map中是否没有特定的key/value存在，如果是，则把key/value存入map，否则merge函数就会被调用，对现有的数值进行修改
        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));
    }
    
    /**
     * 使用stream进行并行执行
     */
    @Test
    public void test9()
    {
        List<String> functionIds = new ArrayList<>(Arrays.asList("1","2","3","4","5"));
        
        List<String> subFunctionIds = new ArrayList<>(Arrays.asList("5","6","7"));
        functionIds = functionIds
        .stream()
        .filter(functionId -> !subFunctionIds.contains(functionId))
        .collect(Collectors.toList());
        System.out.print(functionIds);
    }
    
    @Test
    public void test10()
    {
        List<String> functionIds = new ArrayList<>(Arrays.asList("1","2","3","4","5"));
        String targetId = "4";
        if(functionIds.parallelStream().anyMatch(id -> id.equals(targetId)))
        {
            System.out.println(targetId);
        }
    }
    
    @Test()
    public void test11()
    {
        Map<String, Object> map = new TreeMap<>();
        map.put("1", 1);
        map.put("3", "2");
        map.put("2", 5);
        for(Map.Entry<String, Object> entry : map.entrySet())
        {
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }
    }
    
    @Test
    public void test12() {
        Set<String> set = new CopyOnWriteArraySet<>();
        List<String> officeIds = Arrays.asList("0,cd44eff5283b4321b2ac5cb7df4387fd,0da59645a72c4f52b0e012ee0958a30f",
                "0,05d8e9a3167e4c27ac08152cc0103b75,b8d5c7bd30a04c97b8a68547ccc0f5fd,",
                "0,05d8e9a3167e4c27ac08152cc0103b75,b8d5c7bd30a04c97b8a68547ccc0f5fd,031453221e124b9fa2e3b8fc9bb4688e,");
        List<String> pureOfficeIds = officeIds.stream().filter(id -> !"0,".equals(id)).map(id -> id.substring(2)).collect(Collectors.toList());
        pureOfficeIds.parallelStream().forEach(parentOfficeId -> {
            String[] ids = parentOfficeId.split(",");
            set.addAll(Arrays.asList(ids));
        });
        System.out.println(set);
    }
    
    @Test
    public void test13() {
        List<String> functionIds = new ArrayList<>(Arrays.asList("1","2","3","4","5"));
        List<String> newFunctionIds = functionIds.parallelStream().filter(id -> "1".equals(id)).collect(Collectors.toList());
        System.out.print(newFunctionIds);
    }
    
    @Test
    public void test14() {
        List<String> functionIds = new ArrayList<>(Arrays.asList("1","2","3","4","5"));
        // findFirst findAny等方法必须和过滤器一起使用
        String target = functionIds.stream().filter(id -> id.equals("1")).findFirst().get();
        System.out.println(target);
    }
}
