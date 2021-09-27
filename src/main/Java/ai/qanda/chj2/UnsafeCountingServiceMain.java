package ai.qanda.chj2;

import ai.qanda.util.ConcurrentUtil;

public class UnsafeCountingServiceMain {
    public static void main(String[] args) {
        UnsafeCountingService service = new UnsafeCountingService();
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
