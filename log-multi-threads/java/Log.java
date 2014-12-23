
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Log {


    public static void main(String[] args) {
        long ts = System.currentTimeMillis();
        
        CountDownLatch latch = new CountDownLatch(1000000000 / 200);
        ExecutorService pool = Executors.newFixedThreadPool(8);
        
        double[] logs = new double[1000000000];
        
        for (int i = 0; i < logs.length; i += 200) {
            pool.execute(new LogCalc(logs, i, latch));
        }

        pool.shutdown();


        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		long time = (System.currentTimeMillis() - ts);
        System.out.println(String.format("Exec time: %d secs, %d ms", time / 1000, time % 1000));
    }
}


class LogCalc implements Runnable {

    double[] logs;
    private int i;
    private CountDownLatch latch;

    public LogCalc(double[] logs, int i, CountDownLatch latch) {
        this.logs = logs;
        this.i = i;
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int j = i; j < i + 200; j++) {
            logs[j] = Math.log(j + 1);
        }
        latch.countDown();
    }
}

