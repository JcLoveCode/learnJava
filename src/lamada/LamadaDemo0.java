package lamada;

public class LamadaDemo0 {
    public static void main(String[] args) {
        //匿名内部类开启一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("123333");
            }
        }).start();
        //左侧： 指定了 Lambda 表达式需要的方法参数列表←→右侧： 指定了 Lambda 体，即 Lambda 表达式要执行的功能
        //使用lamada表达式运行内部接口
        new Thread(() -> System.out.println("-------------")).start();
    }
}
