package parallelStream;

import java.util.stream.LongStream;

public class ParallelSum {
    public static long parallelSum(long n) {
        return LongStream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public static long rangeSum(long n){
        return LongStream.rangeClosed(1L,n).parallel().reduce(0,Long::sum);
    }
}
