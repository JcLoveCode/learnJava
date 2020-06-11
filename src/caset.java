import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class caset {
    private final static Lock lock=new ReentrantLock();
    public static void main(String[] args) {
        float a=Float.valueOf(1.0f-0.9f);
        float b= Float.valueOf(0.9f-0.8f);
        System.out.println(a);
        System.out.println(b);
        if (a == b) {

            System.out.println("ture");
        } else {
            System.out.println("false");
        }
        String aa=null;
 /*       switch (aa) {
            case "null":
                System.out.println("null is true");
                break;
            default:
                System.out.println("default");
        }*/
        BigDecimal bigDecimal = new BigDecimal(0.1);
        System.out.println(bigDecimal);
        BigDecimal bigDecimal1 = new BigDecimal("0.1");
        System.out.println(bigDecimal1);

        try {
            lock.tryLock();
            System.out.println("111");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("222");

        } finally {
            System.out.println("333");
            lock.unlock();
            System.out.println("444");
        }
    }

}
