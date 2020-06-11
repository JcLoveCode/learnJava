package lamada;


@FunctionalInterface
public  interface MyInterface<T,R>{
//根据method返回类型R的的方法.
    R method(T t);//有参数, 可以使用java8中已经存存在的function.


}
