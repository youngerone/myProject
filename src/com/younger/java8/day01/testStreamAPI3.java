package com.younger.java8.day01;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Stream的API
 */
public class testStreamAPI3 {


    List<Employpee> emps = Arrays.asList(
            new Employpee(101, "张三", 18, 9999.99, Employpee.Status.FREE),
            new Employpee(102, "李四", 59, 6666.66, Employpee.Status.BUSY),
            new Employpee(103, "王五", 28, 3333.33, Employpee.Status.FREE),
            new Employpee(104, "赵六", 8, 7777.77, Employpee.Status.BUSY),
            new Employpee(105, "田七", 38, 5555.55, Employpee.Status.VOCATION)
    );

    @Test
    public void test1() {


        //allMatch 是不是匹配所有元素

        //anyMatch 检查是否只是匹配一个元素

        //noneMatch 检查是否没有匹配所有元素

        //findfirst 返回第一个元素

        //count 返回流中元素的总个数

        //max 返回流中的最大值
        // min 返回 流中最小值

        //Optional

        // emps.stream().allMatch((e)-> Employpee.Status)
    }

    @Test
    public void test2() {
        //规约
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);

        System.out.println(reduce);

        System.out.println("-----------------");

        //map中存储的是工资
        Optional<Double> reduce1 = emps.stream().map(Employpee::getSalary).reduce(Double::sum);

        System.out.println(reduce1.get());

        //map-reduce模式
    }

    //收集
    @Test
    public void test3() {

        //对结果的收集 可以存放到任意的集合中

        List<String> collect = emps.stream().map(Employpee::getName).collect(Collectors.toList());

        collect.forEach(System.out::println);


        System.out.println("------------------");
        Set<String> collect1 = emps.stream().map(Employpee::getName).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
        System.out.println("----------------");

        ArrayList<String> collect2 = emps.stream().map(Employpee::getName).collect(Collectors.toCollection(ArrayList::new));
        collect2.forEach(System.out::println);
        System.out.println("--------------------");

        //总数
        Long collect3 = emps.stream().collect(Collectors.counting());
        System.out.println("总数:"+collect3);

        //平均值
        Double collect4 = emps.stream().collect(Collectors.averagingDouble(Employpee::getSalary));
        System.out.println(collect4);
        System.out.println("----------------");


        //总和
        DoubleSummaryStatistics collect5 = emps.stream().collect(Collectors.summarizingDouble(Employpee::getSalary));
        System.out.println(collect5);
        System.out.println("--------------------");

        //最大值
        Optional<Employpee> collect6 = emps.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(collect6);
        System.out.println("--------------------");

        //最小值
        Optional<Double> collect7 = emps.stream().map(Employpee::getSalary).collect(Collectors.minBy(Double::compare));
        System.out.println(collect7);

        System.out.println("-------------------");

        //分组
        Map<String, List<Employpee>> collect8 = emps.stream().collect(Collectors.groupingBy(Employpee::getName));
        System.out.println(collect8);
        System.out.println("--------------");

        //多级分组
        Map<String, Map<Object, List<Employpee>>> collect9 = emps.stream().collect(Collectors.groupingBy(Employpee::getName, Collectors.groupingBy((e)->{
            if (((Employpee) e).getAge()<=35){
                return "青年";

            }else{
                return "老年";
            }
        })));

        System.out.println(collect9);

        System.out.println("-----------------------");

        //分区 满足条件一个区 不满足条件一个区
        Map<Boolean, List<Employpee>> collect10 = emps.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(collect10);

        System.out.println("----------------------------");
     // emps.stream().collect(Collectors.s)


    }
}
