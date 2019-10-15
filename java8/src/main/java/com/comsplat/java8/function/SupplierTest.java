package com.comsplat.java8.function;

import java.util.function.Supplier;

/**
 * @program: begging
 * @description:
 * @author: Mamy
 * @create: 2019-09-17 15:33
 */
public class SupplierTest {

    public static void main(String[] args) {

        // 直接理解成一个创建对象的工厂

        Supplier<String> s = String::new;
        System.out.println(s.get());

        Supplier<Emp> s1 = Emp::new;
        Emp e = s1.get();
        e.setName("aaa");
        System.out.println(e.getName());
    }

    static class Emp {
        private String name;

        public Emp() {

        }

        public Emp(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
