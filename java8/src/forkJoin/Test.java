package forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class Test{
    public static void main(String[] args) {
        long sum = forkJoinSum(10_000_000);
        System.out.println(sum);
    }
    public static long forkJoinSum(long n){
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinSumCalculator task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
}
