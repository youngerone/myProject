package com.younger.java8.day01.testLambda;

import com.younger.java8.day01.Employpee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Lambda练习
 */
public class TestLambda3 {

    List<Employpee> emps = Arrays.asList(
            new Employpee(101, "张三", 18, 9999.99),
            new Employpee(102, "李四", 59, 6666.66),
            new Employpee(103, "王五", 28, 3333.33),
            new Employpee(104, "赵六", 8, 7777.77),
            new Employpee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test1(){
        Collections.sort(emps,(x,y)->{
            if(x.getAge()==y.getAge()){
                return  x.getName().compareTo(y.getName());
            }else{
                return  Integer.compare(x.getAge(),y.getAge());
            }
        } );

        for(Employpee employpee:emps){
            System.out.println(employpee);
        }
    }



}
