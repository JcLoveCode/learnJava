package lamada;

public class LamadaDemo5 {

    public static void main(String[] args) {

        //(1)传统的方式
        MyInterface<String,MyClass> myInterface1 = new MyInterface<String, MyClass>() {
            @Override
            public MyClass method(String s) {
                return new MyClass(s);
            }
        };
        //(2)Lamada方式---首先实现此方法  T是传递的参数, Mycalss返回的类型

        MyInterface<String, MyClass> myInterface2 = (s) -> new MyClass(s);
        MyClass myClass1 = myInterface1.method("传值");
        //接口一会不会打印日志
        System.out.println(myClass1.s);


        myInterface1.method("正常传值");

        //(3)构造器引用的方式---不管参数了列表了，简化方法体

        MyInterface<String, MyClass> myInterface3 = MyClass::new;


        MyClass myclass = myInterface3.method("你好吗？");

        System.out.println(myclass.s);

        //不管哪种方法，调用时传实参的形式是一致的


    }


}
