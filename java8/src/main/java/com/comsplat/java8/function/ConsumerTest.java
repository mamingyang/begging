package com.comsplat.java8.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @program: begging
 * @description:
 * @author: Mamy
 * @create: 2019-09-17 15:19
 */
public class ConsumerTest {

    public static void main(String[] args) {
        // 接受入参，无返回
        // 主要是对入参做一些列的操作，在stream里，主要是用于forEach；内部迭代的时候，对传入的参数，做一系列的业务操作，没有返回值；
        test1();

        // BiConsumer   接受2个参数 类似Consumer
        // 使用这个函数式接口的终端操作有map的遍历
        test2();

    }

    private static void test2() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");

        map.forEach((x,y) -> System.out.println(x + " " +y ));

        BiConsumer<String,String> bi = (x,y) -> System.out.println(x + " " +y);
        bi.accept("a" ,"b");
    }

    private static void test1() {

        Consumer<String> c = x -> System.out.println(x);
        c.accept("hello world");

        Consumer<Integer> c2 =System.out::println;
        c2.accept(2);

        List<Integer> ar = new ArrayList<>(10);
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(4);
        ar.forEach(System.out::println);
    }
}
