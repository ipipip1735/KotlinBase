import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2021/8/7.
 */
public class TheThread {
    public static void main(String[] args) {
//        new Thread(()->{
//            System.out.println(Thread.currentThread());
//        }).start();




        Timer timer = new Timer("Timer");
        for (int i = 0; i < 5; i++) {
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread());
//                System.out.println("scheduledExecutionTime() is " + scheduledExecutionTime());
                }
            };
            timer.schedule(timerTask, 1000L);
        }
        timer.purge();

//        timer.purge();

//        timer.scheduleAtFixedRate(timerTask, 1000L, 2000L);


    }
}
