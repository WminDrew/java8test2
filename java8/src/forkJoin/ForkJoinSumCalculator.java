package forkJoin;

import transaction.Transaction;

import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers){
        this(numbers,0,numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        //如果数组的长度小于阈值，直接顺序计算
        if(length <= THRESHOLD){
            return computeSequentially();
        }
        //如果数组的长度大于阈值，将任务分为两个子任务
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers,start,start+length/2);
        leftTask.fork();//左任务传给线程池，线程池会调用一个线程去执行它
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers,start+length/2,end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();//读取第一个任务的结果
        return leftResult+rightResult;
    }

    private long computeSequentially(){
        long sum = 0;
        for (int i = start;i < end; i++){
            sum += numbers[i];
        }
        return sum;
    }

}
