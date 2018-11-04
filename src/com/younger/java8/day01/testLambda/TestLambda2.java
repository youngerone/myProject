package com.younger.java8.day01.testLambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda 表达式基础语法:java8 引入一个新的操作符 "->" 箭头操作符 或者Lambda表达式
 *
 * 左侧:Lambda 表达式参数列表
 * 右侧: Lambda 表达式所需执行的功能,即Lambda体
 *
 * 语法格式一:无参数,无返回值
 * () -> System.out.print();
 *
 * 语法格式二:有一个参数,并且无返回值
 * (x) -> System.out.println(x);
 *
 * 语法格式三:若一个参数,小括号可以省略不写.
 * x -> System.out.println(x);
 *
 * 语法格式四:有两个以上的参数,并且Lambda体中 有多条数据。有返回值
 *  Comparator<Integer> com = (x,y)->{
 *   System.out.println("函数式接口");
 *    return  Integer.compare(x,y);
 * };
 * 语法格式五:若Lambda体中只有一条语句,return 和 大括号都可以省略不写。
 *  Comparator<Integer> com = (x,y)->
 *   System.out.println("函数式接口");
 *  Integer.compare(x,y);
 *
 * 语法格式六:Lambda表达式参数列表的类型可以不写。
 *
 * 二.Lambda表达式需要"函数式接口"的支持。
 * 函数式接口:接口中只有一个抽象方法的接口,称为函数式接口。可使用注解@FunctionInterface修饰,
 * 可以检查是否是函数式接口。
 */
public class TestLambda2 {


    @Test
    public void test(){
        int num = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {

                System.out.println("运行中....");
            }
        };

        r.run();
        Runnable r1 = ()-> System.out.println("运行"+num);

        r1.run();
    }


    @Test
    public void test2(){
        Consumer<String> str = x-> System.out.println(x);
        str.accept("你好");
    }

    public void test3(){

        Comparator<Integer> com = (x,y)->{
            System.out.println("函数式接口");
            return  Integer.compare(x,y);
        };
    }

    //需求:对一个数进行运算
    @Test
    public void test4(){

        Integer num = operation(100, x -> x + x);
        System.out.println(num);

        System.out.println(operation(100,x->x*x));

    }

    public Integer operation(Integer num,MyInterface myInterface){

        return myInterface.getValue(num);
    }

    //对输入的字符串转成大写
    @Test
    public void test5(){

        System.out.println(strToLowcase("stre",x->x.toUpperCase()));

        String str = strToLowcase("rirtiriri", x -> x.substring(2, 4));
        System.out.println(str);
    }

    @Test
    public void test7(){
        op(2L,3L,(x,y)->x+y);
        op(3L,4L,(x,y)->x*y);
    }

    public String strToLowcase(String str,MyFunc func){

        return func.getValue(str);
    }

    //需要对两个long型进行处理
    public void  op(long l1 ,long l2,MyFunction2<Long,Long> function2){

        System.out.println(function2.getValue(l1,l2));
    }

}
