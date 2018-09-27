package com.base.java.learnjava8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @package com.example.stream
 * @auther joker
 * @date 2018/5/12 16:08
 */
public class TestStream {

    public static void main(String[] args) {
        Arrays.asList("a", "b", "d").forEach(e -> {
            // System.out.println(e);
        });

        // 构造流
        // 1. 通过Stream类的静态方法
        Stream stream = Stream.of("a", "b", "c");
        // 2. 通过Arrays的静态方法stream()
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Arrays.stream(strArray);
        // 3. 通过集合提供的stream()或parallelStream()
        stream = Arrays.asList(strArray).stream();
        stream = Arrays.asList(strArray).parallelStream();

        /*
         需要注意的是，对于基本数值型，目前有三种对应的包装类型 Stream：
         IntStream、LongStream、DoubleStream
         也可以用 Stream<Integer>、Stream<Long> >、Stream<Double>，
         但是 boxing 和 unboxing 会很耗时，所以特别为这三种基本数值型提供了对应的 Stream
         */

        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }
}
