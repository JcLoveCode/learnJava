package lamada;


@FunctionalInterface
public  interface  MyFunctionInterface <T>{
    void method(T s);//自定义函数式接口---注意其定义
    //用一个注解 @FunctionalInterface 去检测这个接口是不是一个函数式接口,有了这个才表示可以

}
