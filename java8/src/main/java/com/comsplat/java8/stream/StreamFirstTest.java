package com.comsplat.java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @program: begging
 * @description: Stream学习
 * @author: Mamy
 * @create: 2019-09-17 10:16
 */
public class StreamFirstTest {


    public static void main(String[] args) {
        // 创建流
        // creatStream();
//        filter();
//        map();
        flatMap();
    }

    private static void flatMap() {
        String[] strs = { "aaa", "bbb", "ccc" };
        Arrays.stream(strs).map(str -> str.split("")).forEach(System.out::println);
        Arrays.stream(strs).map(str -> str.split("")).flatMap(str -> Arrays.stream(str)).forEach(System.out::println);
    }

    private static void map() {
        // 调用这个函数后，可以改变返回的类型
        Integer[] dd = { 1, 2, 3 };
        Stream<Integer> stream = Arrays.stream(dd);
        stream.map(x -> Integer.toString(x)).forEach(x ->{
            System.out.println(x);
            System.out.println(x.getClass());
        });


    }

    private static void filter() {
        // filter方法的作用，是对这个boolean做判断，返回true判断之后的对象
        String[] s = {"a","b","c"};
        Stream<String> stream = Arrays.stream(s);
        stream.filter(x -> x.equals("a")).forEach(System.out::print);

    }

    private static void creatStream() {
        int[] intArray = {1,2,3,4};
        Arrays.stream(intArray).forEach(System.out::print);
//        Arrays.stream(intArray).forEach(e -> System.out.println(e));
        System.out.println();
        Stream.of(intArray).forEach(System.out::print);
        System.out.println();
        Arrays.asList(intArray).stream().forEach(System.out::print);
        System.out.println();
        Stream.iterate(0,x -> x+1).limit(10).forEach(System.out::print);
        System.out.println();
        Stream.generate(() -> "x").limit(10).forEach(System.out::print);
    }


}
