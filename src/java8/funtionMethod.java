package java8;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;
import fanshe.Person;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/*
 *功能描述
 * @author fjc
 * @date 2020-1-17 17:07:26
  java8核心特性应用 设置模板
 * @return
 */
public class funtionMethod {

    public static void main(String[] args) {
        //lamda -- 方法引用
        //创建对象

        Function<Integer,Person> fanshe01=(age)-> {
            return new Person(age);
        };

        BiFunction<Integer,String,Person> function=(age,name)->{
            return new Person(age, name);
        };

        Person apply = fanshe01.apply(123);

        function.apply(1234, "付俊川");


    }



}
