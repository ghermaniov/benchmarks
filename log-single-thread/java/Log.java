
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Log {

     public static void main(String[] args) {

        double[] logs = new double[1000000000];

        long ts = System.currentTimeMillis();
        for (int i = 0; i < logs.length; i++) {
            logs[i] = Math.log(i + 1);
        }

        long time = (System.currentTimeMillis() - ts);
        System.out.println(String.format("Exec time: %d secs, %d ms", time / 1000, time % 1000));
    }
}
