package com.younger.java8.day01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream流的中间操作
 */
public class testStream2 {

    List<Employpee> emps = Arrays.asList(
            new Employpee(101, "张三", 18, 9999.99),
            new Employpee(102, "李四", 59, 6666.66),
            new Employpee(103, "王五", 28, 3333.33),
            new Employpee(104, "赵六", 8, 7777.77),
            new Employpee(105, "田七", 38, 5555.55)
    );
    @Test
    public void test1(){

        //中间操作不会执行任何操作
        Stream<Employpee> s = emps.stream().filter((e) -> {
            System.out.println("中间操作");
            return e.getAge() > 35;
        });
        //中止操作  “惰性求值”
      s.forEach(System.out::println);
    }

    @Test
    public void test2(){
        Stream<Employpee> stream = emps.stream().filter((e) -> e.getSalary() > 5000).limit(3);
        stream.forEach(System.out::println);
    }

    //skip 跳过
    //distinct 去重
    @Test
    public void test3(){
        emps.stream().filter((e)->e.getSalary()>5000).skip(2).distinct().forEach(System.out::println);
    }


    /**
     * 映射
     */
    @Test
    public  void test4(){
        List<String> list =Arrays.asList("aa","bb","cc");
       // list.stream().map((str)->str.toUpperCase()).forEach(System.out::println);
        emps.stream().map(Employpee::getName).forEach(System.out::println);

       // Stream<Stream<Character>> streamStream = list.stream().map(testStream2::fiterCharacter);
       // streamStream.forEach((sm)->sm.forEach(System.out::println));

        //filatmap

        Stream<Character> st = list.stream().flatMap(testStream2::fiterCharacter);
        st.forEach(System.out::println);

    }



    public static Stream<Character> fiterCharacter(String str){

        List<Character> list = new ArrayList<Character>();
        for(Character ch:str.toCharArray()){
            list.add(ch);
        }
        return  list.stream();
    }


    //排序 sorted()-->comparable
    //sorted(Comparator) 定制排序
    @Test
    public  void test5(){
        List<String> list =Arrays.asList("aa","bb","cc");
        list.stream().sorted().forEach(System.out::println);


        emps.stream().sorted((e1,e2)->{
           if(e1.getAge()==e2.getAge()){
               return e1.getName().compareTo(e2.getName());
           }else{
               return e1.getAge()-e2.getAge();
           }
        }).forEach(System.out::println);
    }
}
