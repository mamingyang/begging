package com.comsplat.java8.lambda;


import java.util.Comparator;
import java.util.function.*;

/**
 * @program: begging
 * @description: lambda表达式
 * @author: Mamy
 * @create: 2019-09-17 11:24
 */
public class LambdaTest {

    public static void main(String[] args) {

        // 无参数，无返回值的用法 ：() -> System.out.println("hello lambda");
        test1();
        // .有一个参数，无返回值的用法： (x) -> System.out.println(x); 或者 x -> System.out.println(x); 一个参数，可以省略参数的小括号
        test2();
        // 有2个参数，有返回值的：(x, y) -> x + y
        test3();
        // 上面的例子，函数体中都是只有一个语句，下面是多行语句，分别在无返回值和有返回值的抽象类中的用法
        // 多行的只需要用{}包括起来就行了，有返回值和无返回值只有一个return的区别;只有一行语句的，{}和return都可以不写
        test4();
        // 在lambda中的参数列表，可以不用写参数的类型，跟java7中 new ArrayList<>(); 不需要指定泛型类型，这样的<>棱形操作符一样，根据上下文做类型的推断
        test5();

        // 方法的引用 和 构造器的引用
        System.out.println("----------");
        test6();
    }

    private static void test6() {
        /**********方法的引用**********/
        // 类::静态方法名
        Comparator<Integer> c = (x,y) -> x.compareTo(y);
        System.out.println(c.compare(4,2));
        Comparator<Integer> c2 = Integer::compareTo;
        System.out.println(c2.compare(2,3));
        // 类::实例方法名
        BiPredicate<String,String> b = (x,y) -> x.equals(y);
        System.out.println(b.test("a","b"));
        BiPredicate<String,String> b2 = String::equals;
        System.out.println(b2.test("c","c"));
        // 对象::实例方法名
        Consumer<String> con = x -> System.out.println(x);
        con.accept("您好");
        Consumer<String> conn2 = System.out::println;
        conn2.accept("我不好");

        Emp emp = new Emp("上海","xm",18);
        Supplier<String> s = () -> emp.getAddress();
        System.out.println(s.get());
        Supplier<String> s2 = emp::getAddress;
        System.out.println(s2.get());

        // 构造器的引用
        // 无参数
        Supplier<Emp> su = () -> new Emp();
        Supplier<Emp> su2 = Emp::new;
        Emp emp1 = su2.get();
        emp1.setName("无参数构造");
        // 一个参数
        Function<String,Emp> f1 = addr -> new Emp(addr);
        Function<String,Emp> f2 = Emp::new;
        System.out.println(f1.apply("一个参数1"));
        System.out.println(f2.apply("一个参数2"));
        // 二个参数
        BiFunction<String,Integer,Emp> bi1 = (name,age) -> new Emp(name,age);
        BiFunction<String,Integer,Emp> bi2 = Emp::new;
        System.out.println(bi1.apply("bi1",17));
        System.out.println(bi2.apply("bi2",10));
    }

    static class Emp{
        private String address;

        private String name;

        private Integer age;

        public Emp() {

        }

        public Emp(String address) {
            this.address = address;
        }

        public Emp(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Emp(String address, String name, Integer age) {
            super();
            this.address = address;
            this.name = name;
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Emp [address=" + address + ", name=" + name + ", age=" + age + "]";
        }

    }

    private static void test5() {
        BinaryOperator<Integer> bin = (Integer x,Integer y) -> x+y;
        System.out.println(bin.apply(3,4));
    }

    private static void test4() {
        // 多行无返回值的
        Runnable r = () -> {
            System.out.println("h1");
            System.out.println("h2");
            System.out.println("h3");
        };
        r.run();
        // 多行有返回值的
        BinaryOperator<Integer> bin = (x,y) ->{
            int a = x*2;
            int b = y*3;
            return a+b;
        };
        System.out.println(bin.apply(2,3));
    }

    private static void test3() {
      BinaryOperator<Integer> bin = (x,y) -> x+y;
        System.out.println(bin.apply(3,4));
    }

    private static void test2() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("有一个参数，无返回值的用法（Consumer函数式接口）");
    }

    private static void test1() {
        Runnable r =  new Runnable(){
            @Override
            public void run() {
                System.out.println("lambda");
            }
        };
        r.run();

        Runnable r1 = () -> System.out.println("lambda");
        r1.run();
    }

}
