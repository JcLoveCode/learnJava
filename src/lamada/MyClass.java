package lamada;


public class MyClass {

    String s = null;

    public MyClass(String s) {

        //有参的构造方法--无参的更简单
        this.s = s;

        System.out.println(s+"有参的构造方法");
    }

}
