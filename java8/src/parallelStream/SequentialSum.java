package parallelStream;

import java.util.stream.LongStream;

public class SequentialSum  {
    public static long sequentialSum(long n) {
        return LongStream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    //使用rangeClosed方法生成
    public static long rangeSum(long n){
        return LongStream.rangeClosed(1L,n).reduce(0,Long::sum);
    }
}
