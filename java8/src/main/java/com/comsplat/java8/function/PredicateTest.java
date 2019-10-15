package com.comsplat.java8.function;

import java.util.function.Predicate;

/**
 * @program: begging
 * @description: 断言
 * @author: Mamy
 * @create: 2019-09-17 17:27
 */
public class PredicateTest {

    public static void main(String[] args) {

        // 数字类型 判断值是否大于5
        Predicate<Integer> p1 = x -> x>10;
        System.out.println(p1.test(5));
        // 字符串比较
        Predicate<String> p2 = x -> x == null || "".equals(x);
        System.out.println(p2.test(""));
    }
}
