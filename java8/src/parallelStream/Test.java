package parallelStream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.function.Function;
import java.util.stream.LongStream;

public class Test {
    private static final long MAX = 100000;

    public static void main(String[] args) {
        //        long doTime = measureSumPref(SequentialSum::sequentialSum, 10_000_000);
//        long doTime = measureSumPref(IterativeSum::iterativeSum, 10_000_000);
//        long doTime = measureSumPref(ParallelSum::parallelSum, 10_000_000);
//        long doTime = measureSumPref(SequentialSum::rangeSum, 10_000_000);
//        long doTime = measureSumPref(ParallelSum::rangeSum, 10_000_000);
//        System.out.println("doTime: "+doTime);
//        long ss = LongStream.iterate(0L, i -> i + 2).limit(10).sum();
//        System.out.println(ss);
    }

//    public static long sequentialSum(long n) {
//        return LongStream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
//    }

//    public static long parallelSum(long n) {
//        return LongStream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
//    }
//
//    public static long iterativeSum(long n) {
//        long result = 0;
//        for (long i = 1L; i <= n; i++) {
//            result += i;
//        }
//        return result;
//    }

    public static long measureSumPref(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long dutation = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (dutation < fastest) fastest = dutation;
        }
        return fastest;
    }
}
