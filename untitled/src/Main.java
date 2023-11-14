/**
 * Description：
 * User: lmp
 * Date: 2023-10-25
 * Time: 20:08(李明浦)
 */
public class Main {
    public static void serial() {
        long beg = System.currentTimeMillis();
        long a = 0;
        for (int i = 0; i < 10_0000_0000; i++) {
            a++;
        }
        long b = 0;
        for (int i = 0; i < 10_0000_0000; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.print((end-beg)+"ms");
    }
    public static void concurrency() throws InterruptedException {
        long beg = System.currentTimeMillis();
        Thread t1 = new Thread(()->{
            long a = 0;
            for (int i = 0; i < 10_0000_0000; i++) {
                a++;
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            long b = 0;
            for (int i = 0; i < 10_0000_0000; i++) {
                b++;
            }
        });
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.print((end-beg)+"ms");
    }
    public static void main(String[] args) throws InterruptedException {
        serial();
        System.out.println();
        concurrency();
    }

}