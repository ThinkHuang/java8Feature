package com.huang.feature.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomeRecursiveTask extends RecursiveTask<Integer>
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 4624333004053651118L;

    private int[] arr;
    
    private static final int THRESHOLD = 20;
 
    public CustomeRecursiveTask(int[] arr) {
        this.arr = arr;
    }
 
    @Override
    protected Integer compute() {
        if (arr.length > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
              .stream()
              .mapToInt(ForkJoinTask::join)
              .sum();
        } else {
            return processing(arr);
        }
    }
 
    private Collection<CustomeRecursiveTask> createSubtasks() {
        List<CustomeRecursiveTask> dividedTasks = new ArrayList<>();
        dividedTasks.add(new CustomeRecursiveTask(
          Arrays.copyOfRange(arr, 0, arr.length / 2)));
        dividedTasks.add(new CustomeRecursiveTask(
          Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
        return dividedTasks;
    }
 
    private Integer processing(int[] arr) {
        return Arrays.stream(arr)
          .filter(a -> a > 10 && a < 27)
          .map(a -> a * 10)
          .sum();
    }
    
    public static void main(String[] args) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        int[] arr = {1, 2, 3, 4};
        CustomeRecursiveTask customRecursiveTask = new CustomeRecursiveTask(arr);
        commonPool.execute(customRecursiveTask);
        int result = customRecursiveTask.join();
        System.out.println(result);
    }
    
}
