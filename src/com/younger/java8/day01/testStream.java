package com.younger.java8.day01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * java8 流Stream
 *
 * Stream的三个操作：
 * 1.创建stream
 * 2.中间操作
 * 3.中止操作
 *
 */
public class testStream {

    @Test
    public void test1(){

        //可以通过collection系列集合提供的stream()或paralletStream()

        List<String> list = new ArrayList<String>();
        //1.得到流
        Stream<String> stream = list.stream();

        //2.得到流
        Employpee[] employpees = new Employpee[10];
        Stream<Employpee> stream1 = Arrays.stream(employpees);
        
        //3.通过Stream的静态方法of()
        Stream<String> aa = Stream.of("aa", "bb", "cc");

        //4.创建无限流
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x+2);
        //生成
        iterate.limit(20).forEach(System.out::println);

        Stream.generate(()->Math.random()).limit(5).forEach(System.out::println);
    }
}
