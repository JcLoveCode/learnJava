package FourMasterInterface;

import com.alibaba.fastjson.JSON;
import fanshe.Student;
import jdk.nashorn.internal.runtime.JSONFunctions;
import lamada.MyClass;
import fanshe.Person;
import org.junit.Test;
import sun.dc.pr.PRError;
import sun.rmi.log.LogInputStream;

import javax.sound.midi.Soundbank;
import java.beans.Customizer;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import FourMasterInterface.FuncitonDemo;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class fourInterfaceClass {
    //消费型接口consumer"
    //@Test
    public void testConstomer() {
        getMoney(20000, (money) -> System.out.println("每月挣了多少钱?" + money));
    }

    public void getMoney(int money, Consumer con) {
        con.accept(money);
    }

    @Test
    public void testConsumer() {

        List<String> lists = Arrays.asList("3", "2", "1");
        Stream.of(lists).forEach(System.out::print);
        lists.forEach(System.out::println);

        List<Person> stuList = new ArrayList<Person>();
        Consumer<Person> constu = x -> {
          //做判断
            if (x.name.equals("list")) {
                stuList.add(x);
            }
        };

        //第一种情况   快捷键itit  itli iter   itar 4种类型的循环
        Stream.of(
                new Person(21,"zhangsan"),
                new Person(22,"lisi"),
                new Person(23,"wangwu"),
                new Person(24,"wangwu"),
                new Person(23,"lisi"),
                new Person(26,"lisi"),
                new Person(26,"zhangsan")
        ).forEach (constu);
        //因为需要cast将类型装换成customer接口.
        System.out.println(JSON.toJSONString(stuList));
        //这个时
        constu = constu.andThen(X -> stuList.removeIf(y -> y.name.equals("list")));
        System.out.println(JSON.toJSONString(stuList));

        //测试是用lamada表达式
        Runnable cronTask = new Runnable() {
            @Override
            public void run() {
                // do something
            }
        };
        //大致理解：用lambda表达式构造方法实体，等价于实现了接口中的方法，最终lambda表达式的返回值就是接口的实现类
        Runnable runableLambda = ()->{
            //do something
        };
    }

    @Test
    public void testSupperDemo() {
        //供给型接口
        List<Integer> getNumlist = getNumList(10, () -> (int) Math.random() * 100);
        for (int i = 0; i < getNumlist.size(); i++) {
            Integer integer =  getNumlist.get(i);
            System.out.println(integer);
        }
        //例子二商上面是从左导
        Supplier<String> supplier2 = () -> "大傻逼";
        Supplier<Person> supplier3 = () -> new Person(111, "23213");
   //     Supplier<Person> supplier4 = () -> Person::new;   --不知道为啥不管用
        System.out.println(supplier3.get().getAge());
        System.out.println(supplier2.get());
     //   System.out.println(supplier4.get().getName());


    }

    //生成一些整数放入集合中
    public List<Integer> getNumList(Integer num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    @Test
    //函数型接口
    public void testFounctionDemo() {
        //传递的是函数
        String trimStr = functionT0String("付  俊 川  ", (str) -> str.trim());
        System.out.println(trimStr);

        int compute = compute(2, value -> value * 3, value -> value * value);
        int compute2 = compute2(2, value -> value * 3, value -> value * value);
        System.out.println(compute);
        System.out.println(compute2);

    }

    //用来处理字符串

    public String functionT0String(String str, FuncitonDemo<String, String> fun) {
        return fun.apply(str);

    }
    //写一个泛型式子接受
    //                     2                x=x*3 ,                     x=x*x
    public <T> T compute(T a, Function<T,T> function1,Function<T,T> function2){
        return function1.compose(function2).apply(a);
        //        //      (x=x*3)   x=x*x
    }
//nt compute = compute(2, value -> value * 3, value -> value * value);
    public <T> T compute3(T a, Function<T,T> function1){
        return function1.apply(a);
        //      (x=x*3)   x=x*x
    }
    //andThen
    //                     2                x=x*3 ,                     x=x*x
    public <T> T compute2(T a,Function<T,T> function1,Function<T,T> function2){
        return function1.andThen(function2).apply(a);
    }


    @Test
    //断言型接口
    public void Predicate() {
        //基本例子
        Predicate<String> predicate= p->p.length()>5;
        boolean ddd = predicate.test("我的名字叫做依恋");
        System.out.println(ddd);
        //基本例子二

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        conditionFilter(list,item -> item % 2 == 0);

        conditionFilter(list,item -> item > 5);

        conditionFilter(list,item -> true);

        //找出集合中所有大于5且为偶数的元素
        conditionFilter2(list,item -> item > 5,item -> item % 2 == 0);

        //找出集合中大于5或为偶数的元素
        conditionFilter3(list,item -> item > 5,item -> item % 2 == 0);

        //找出集合中所有大于5且为偶数的元素基础上取反
        conditionFilter4(list,item -> item > 5,item -> item % 2 == 0);

        boolean test1 = isEqual("hello").test("hello");
        System.out.println(test1);

        boolean test2 = isEqual(new Date()).test(new Date());
        System.out.println(test2);







    }

    //内部有4中方法
    public static <T> void conditionFilter(List<T> list, Predicate<T> predicate){
        list.forEach(t -> {
            if(predicate.test(t)){
                System.out.println(t);
            }
        });
    }

    public static <T> void conditionFilter2(List<T> list,Predicate<T> predicate1,Predicate<T> predicate2){
        list.forEach(item -> {
            if(predicate1.and(predicate2).test(item)){
                System.out.println(item);
            }
        });
    }

    public static <T> void conditionFilter3(List<T> list,Predicate<T> predicate1,Predicate<T> predicate2){
        list.forEach(item -> {
            if(predicate1.or(predicate2).test(item)){
                System.out.println(item);
            }
        });
    }

    public static <T> void conditionFilter4(List<T> list,Predicate<T> predicate1,Predicate<T> predicate2){
        list.forEach(item -> {
            if(predicate1.and(predicate2).negate().test(item)){
                System.out.println(item);
            }
        });
    }

    public static <T> Predicate<T> isEqual(T t){
        return Predicate.isEqual(t);
    }





}

