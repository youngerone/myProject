package com.younger.java8.day01;

import org.junit.Test;
import java.util.*;

public class TestLambda {

    @Test
    public void test1(){

        Comparator<Integer>  com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer>  ts = new TreeSet<>(com);
    }

    //Lambda表达式
    @Test
    public void test2(){

        Comparator<Integer> com = (x,y)-> Integer.compare(x,y);

        TreeSet<Integer>  ts = new TreeSet<>(com);
    }

    List<Employpee> emps = Arrays.asList(
            new Employpee(101, "张三", 18, 9999.99, Employpee.Status.FREE),
            new Employpee(102, "李四", 59, 6666.66, Employpee.Status.BUSY),
            new Employpee(103, "王五", 28, 3333.33, Employpee.Status.FREE),
            new Employpee(104, "赵六", 8, 7777.77, Employpee.Status.BUSY),
            new Employpee(105, "田七", 38, 5555.55, Employpee.Status.VOCATION)
    );

    //需求：获取公司中年龄小于 35 的员工信息

    public List<Employpee> filterEmployee(List<Employpee> emps){

        List<Employpee> list = new ArrayList<Employpee>();

        for (Employpee emp:emps){

            if (emp.getAge()<=35){
                list.add(emp);
            }
        }
        return  list;
    }


    @Test
    public void test3(){

        List<Employpee> list = filterEmployee(emps);

        for(Employpee employpee:list){

            System.out.println(employpee);
        }

    }
   //需求：获取公司中工资大于 5000 的员工信息
   public List<Employpee> filterEmployeeBysalar(List<Employpee> emps){

       List<Employpee> list = new ArrayList<Employpee>();

       for (Employpee emp:emps){

           if (emp.getSalary()>=5000){
               list.add(emp);
           }
       }
       return  list;
   }

    //优化方式一：策略设计模式

    public List<Employpee> filterEmployee(List<Employpee> emps,MyFilter<Employpee> m){

        List<Employpee> list = new ArrayList<Employpee>();
        for(Employpee employpee:emps){

            if(m.test(employpee)){
                list.add(employpee);
            }
        }

        return  list;
    }

    @Test
    public void test4(){

        List<Employpee> list = filterEmployee(emps, new FilterSalar());
        for(Employpee employpee :list){
            System.out.println(employpee);
        }
    }


    @Test
    public void test5(){

        List<Employpee> list = filterEmployee(emps, new FilterAge());

        for (Employpee employpee:list){
            System.out.println(employpee);

        }
    }

    //匿名内部类
    @Test
    public void test6(){
        List<Employpee> list = filterEmployee(emps, new MyFilter<Employpee>() {
            @Override
            public boolean test(Employpee employpee) {
                return employpee.getAge() <= 30;
            }
        });

        for(Employpee employpee:list){
            System.out.println(employpee);
        }
    }

    //Lambda表达式
    @Test
    public void test7(){
       List<Employpee> list =  filterEmployee(emps,(e)->e.getAge()>30);
       list.forEach( System.out::println);
        System.out.println("----------------------");
       List<Employpee> lists = filterEmployee(emps,(e)->e.getSalary()>=5000);
       lists.forEach(System.out::println);
    }

    //Stream api

    @Test
    public void test8(){
        emps.stream().filter((e)->e.getAge()<=30)
                .forEach(System.out::println);
    }

}
