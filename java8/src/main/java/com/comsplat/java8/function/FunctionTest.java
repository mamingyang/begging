package com.comsplat.java8.function;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongToIntFunction;
import java.util.function.ToIntFunction;

/**
 * @program: begging
 * @description:
 * @author: Mamy
 * @create: 2019-09-17 15:01
 */
public class FunctionTest {


    public static void main(String[] args) {

        //****此接口的作用是 是要传入的泛型T参数，然后做业务操作，然后返回泛型R；
        // Funtion这个接口的“扩展”的原始类型特化的一些函数接口 比如 IntFunction<R>  LongToDoubleFunction
        // 这些特殊的Function函数式接口，根据不同的类型，避免了拆箱和装箱的操作，从而提高程序的运行效率
        test1();
    }

    private static void test1() {
        Function<String,String> f = x -> x+"world";
        System.out.println(f.apply("hello "));

        Function<Integer,String> f2 = String::valueOf;
        System.out.println(f2.apply(300));


        IntFunction<String> intf = String::valueOf;
        System.out.println(intf.apply(500));

        ToIntFunction<String> toinf = x -> 3;
        System.out.println(toinf.applyAsInt("10"));


    }
}
