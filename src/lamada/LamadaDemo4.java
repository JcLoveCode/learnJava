package lamada;


import FourMasterInterface.SupplierDemo;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;

public class LamadaDemo4 {
    //概念：方法引用其实是Lambda表达式的另一种写法,当要传递给Lambda体的操作已经有实现的方法了，可以使用方法引用。
    //几种常见形式：
    //
    //        （1）类名::静态方法
    //        （2）对象::实例方法
    //        （3）类名::实例方法
    //
    //注意：
    // *  1. Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保存一致
    //
    // * 2.若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method；不管怎么说，实质还是抽象方法的实现
    //
    //对比：相比而言省略参数列表，是因为二者的类型一致，主要凸显方法(重重之重！！)
    //————————————————
    //版权声明：本文为CSDN博主「wzj_110」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/wzj_110/article/details/80201470
    //语法：使用操作符 “ ::” 将方法名和对象或类的名字分隔开来
    public static void main(String[] args) {


        // 方法引用 :: 是Lambda表达式的另一种简写方式
        //类名::静态方法
        //对象::实例方法
        //类名::实例方法
        SupplierDemo<Double> supplier = new SupplierDemo<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };
        System.out.println(supplier.get());

        SupplierDemo<Double> supplier2 = () -> Math.random();//方法引用
        System.out.println(supplier2.get());


        SupplierDemo<Double> supplier3 = Math::random;

        System.out.println(supplier3.get());
        System.out.println("----------------消费型接口如下---------------------");
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                PrintStream out = System.out;
                out.println(s);
            }
        };
        PrintStream out = System.out;
        Consumer<String> consumer2 = (s) -> out.println(s);
        Consumer<String> consumer3 = out::println;//方法引用也没有参数
        consumer3.accept("bbbb");
        System.out.println("------------------------------");
        Comparator<String> stringComparator = new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                //你对一个函数式接口中的抽象方法重写时，如果说你传的这两个参数
                //一个参数作为了调用者，一个参数作为了 传入者
                //那么你也可以使用方法引用来简写Lambda表达式
                return s1.compareTo(s2);
            }
        };
        Comparator<String> stringComparator2 = (s1, s2) -> s1.compareTo(s2);

        Comparator<String> stringComparator3 = String::compareTo;

        System.out.println("------------------------------------------------");
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        };

        Comparator<Integer> comparator2 = (x, y) -> x.compareTo(y);
        Comparator<Integer> comparator3 = Integer::compareTo;
    }

}

