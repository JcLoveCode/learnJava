package lamada;



public class LamadaDemo3 {
    public static void main(String[] args) {
        new MyFunctionInterface<String>() {
            @Override
            public void method(String s) {
                System.out.println(s);
            }
        }.method("内部构造方法被执行了,没有别重写之前");

        //使用Lamada表达是
        MyFunctionInterface<String> LamaDaMyfucntion=(s)-> System.out.println("lamada 的方法被执行了");
        LamaDaMyfucntion.method("123213213");

    }



}
