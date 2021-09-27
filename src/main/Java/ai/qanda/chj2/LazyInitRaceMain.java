package ai.qanda.chj2;

import ai.qanda.util.ConcurrentUtil;

public class LazyInitRaceMain {
    public static void main(String[] args) {
        LazyInitRace lazyInitRace = new LazyInitRace();
        ConcurrentUtil.run(10, 10, () -> {
            try {
                Thread.sleep(10);
                ExpensiveObject instance = lazyInitRace.getInstance();
                System.out.println("instance = " + instance);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
