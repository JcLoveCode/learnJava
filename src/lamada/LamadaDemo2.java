package lamada;

import org.omg.CORBA.TRANSACTION_MODE;

import java.util.Comparator;
import java.util.TreeSet;

public class LamadaDemo2 {
    public static void main(String[] args) {
        //Treeset 并且顶一个类实现
        //ctrl+alt+空格 先写左边,  ctrl+alt+v空格 先写右边
        TreeSet<String> stringTreeSet = new TreeSet<>(new Comparator<String>() {
            //重写比较器内部类
            @Override
            public int compare(String s1, String s2) {
                int num = s1.length() - s2.length();        //长度为主要条件
                //三元运算符
                System.out.println("s1是:"+s1);
                System.out.println("s2是:"+s2);
                System.out.println("S1和S2比较是:"+s1.compareTo(s2));
                System.out.println("num是:"+num);
                //返回
                return num == 0 ? s1.compareTo(s2) : num;    //内容为次要条件
            }
        });
        stringTreeSet.add("aaaaaaaa");
        stringTreeSet.add("z");
        stringTreeSet.add("wc");
        stringTreeSet.add("nba");
        stringTreeSet.add("cba");
        System.out.println("--------------111--------------");
        System.out.println(stringTreeSet);

        //使用lamada表达式重新写了以后
        System.out.println("-------------2222---------------");          //定义比较器-1 是从右到组,   //1是从左到右
        TreeSet<String> stringTreeSet2= new TreeSet<String>((a,b)->-1);
        stringTreeSet2.add("aaaaaaaa");
        stringTreeSet2.add("z");
        stringTreeSet2.add("wc");
        stringTreeSet2.add("nba");
        stringTreeSet2.add("cba");
        System.out.println(stringTreeSet2);



        //判断





    }

}
