package ai.qanda.chj2;

import ai.qanda.util.ConcurrentUtil;

public class CountingServiceMain {
    public static void main(String[] args) {
        CountingService service = new CountingService();
        ConcurrentUtil.run(10, 10, () -> {
            try {
                Thread.sleep(10);
                System.out.println("count = " + service.service());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
