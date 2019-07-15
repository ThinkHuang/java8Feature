package com.huang.feature.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class CustomRecursiveAction extends RecursiveAction
{
    /**
     * 
     */
    private static final long serialVersionUID = -1322026003927367784L;
    private String workload = "";
    private static final int THRESHOLD = 4;
 
    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }
 
    @Override
    protected void compute() {
        if (workload.length() > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubtasks());
        } else {
           processing(workload);
        }
    }
 
    private List<CustomRecursiveAction> createSubtasks() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();
 
        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2, workload.length());
 
        subtasks.add(new CustomRecursiveAction(partOne));
        subtasks.add(new CustomRecursiveAction(partTwo));
 
        return subtasks;
    }
 
    private void processing(String work) {
        String result = work.toUpperCase();
        System.out.println("This result - (" + result + ") - was processed by "
          + Thread.currentThread().getName());
    }
    
    public static void main(String[] args)
    {
        // 生成任务池
        ForkJoinPool pool = ForkJoinPool.commonPool();
        // 生成主任务
        CustomRecursiveAction task = new CustomRecursiveAction("HelloWorld");
        pool.invoke(task);
    }
}
