package lamada;

import java.util.Arrays;
import java.util.List;

public class LamadaDemo1 {
    public static void main(String[] args) {
        Comparable<Integer> comparable = new Comparable<Integer>() {
            @Override
            public int compareTo(Integer o) {
                return 0;
            }
        };
        //定义五种情况

// 1. 不需要参数,返回值为 5
        //   () -> 5

// 2. 接收一个参数(数字类型),返回其2倍的值
        //    x -> 2 * x

// 3. 接受2个参数(数字),并返回他们的差值
        //    (x, y) -> x – y

// 4. 接收2个int型整数,返回他们的和
        //  (int x, int y) -> x + y

// 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
        //    (String s) -> System.out.print(s)

        // 在 Java 8 中使用双冒号操作符(double colon operator)

        //还有forearch循环
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

        //第一种方式
        players.forEach((player)-> System.out.println(player+":"));
        players.forEach(System.out::println);  //双冒号表达式子.
        //lamada的表达式的写法
        Comparable<Integer> com = (a) -> a;
        Comparable<Integer> com2 = (a) -> 3*a;
        int i = com.compareTo(3);
        int i2 = com2.compareTo(3);
        System.out.println(i);
        System.out.println(i2);

    }

}
