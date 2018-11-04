package com.younger.java8.day01.testLambda02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 内置的四大核心函数式接口
 *
 * Consumer<T> 消费型接口
 *      void accept(T t);
 *
 * Supplier<T>:供给型接口
 *      T get();
 *
 * Function<T,R>：函数型接口
 *      R apply(T t);
 * Predicate<T>:断言型接口
 *      boolean test(T t);
 */
public class TestLambda1 {

    //Consumer 消费型接口

    @Test
    public void test1(){

        happy(100.0,(m)-> System.out.println("消费:"+m));
    }

    public void happy(double money, Consumer<Double> c){

        c.accept(money);
    }

    //Supplier<T>:供给型接口


    //需求:生产指定个数的整数,并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0;i<num;i++){
            Integer e = supplier.get();
            list.add(e);
        }

        return  list;
    }

    @Test
    public void test2(){
        List<Integer> list = getNumList(10, () -> ((int) (Math.random() * 100)));
        for(Integer integer:list){
            System.out.println(integer);
        }
    }

    //Function<T,R>函数型接口

    //用于处理字符串

    public  String strHandle(String str, Function<String,String> fun){

        return  fun.apply(str);
    }

    @Test
    public void test3(){
        String str = strHandle("tregf", (x) -> x.toUpperCase());
        System.out.println(str);
    }


    //Predicate<T>:断言型接口

    //需求:指定的字符添加到集合中

    public  List<String> filterStr(List<String> list, Predicate<String> p){

        List<String> stringList = new ArrayList<String>();

        for (String str :list){
                if(p.test(str)){
                    stringList.add(str);
                }
        }

        return  stringList;
    }

    @Test
    public void test4(){

        List<String> list = new ArrayList<String>();

        list.add("eerrr");
        list.add("eerrr");
        list.add("eerrr");
        list.add("eerrr");

        List<String> stringList = filterStr(list, (x) -> x.length() > 2);
        for (String str:stringList){
            System.out.println(str);
        }
    }
}
