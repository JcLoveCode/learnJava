package fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        Class clazz = null;
        clazz = Class.forName("fanshe.Student");
        Field field = clazz.getField("name");
        Object o = clazz.getConstructor().newInstance();
        field.set(o,"123");
        Student stu = (Student) o;
        System.out.println(stu.name);
        Field phoneNum = clazz.getDeclaredField("phoneNum");
        phoneNum.setAccessible(true);
        phoneNum.set(o,"18518176335");
        System.out.println(o);

        Method show1 = clazz.getMethod("show1", String.class);
        show1.invoke(o, "执行show方法1");
        Method show4 = clazz.getDeclaredMethod("show4", int.class);
        show4.setAccessible(true);
        Object invoke4 = show4.invoke(o, 123);
        System.out.println("返回值"+invoke4);



        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        try {
            Constructor declaredConstructor = clazz.getDeclaredConstructor();
            System.out.println("declearedcon "+declaredConstructor);
            Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
            for (Constructor constructor : declaredConstructors) {
                System.out.println("ArrayConstructors "+constructor);
            }
            Constructor con = clazz.getConstructor(null);
            System.out.println("con= " + con);
            //调用构造方法
      /*      Object obj = */con.newInstance();
         //   System.out.println("obj=" + obj);
           // fanshe.Student stu = (fanshe.Student)obj;


            System.out.println("******************获取私有构造方法，并调用*******************************");
            con = clazz.getDeclaredConstructor(int.class);
            System.out.println(con);
            con.setAccessible(true);
            con.newInstance(111);
            //得到方法
            Method main = clazz.getMethod("main", String[].class);
            //执行main方法并且补齐参数
            main.invoke(null, (Object) new String[]{"a", "b"});



            //调用构造方法
       //     con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
         //   con.newInstance(9999);
           // obj = con.newInstance("男");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
