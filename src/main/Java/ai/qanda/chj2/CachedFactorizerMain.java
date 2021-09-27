package ai.qanda.chj2;

import ai.qanda.util.ConcurrentUtil;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CachedFactorizerMain {
    public static void main(String[] args) {
        CachedFactorizer factorizer = new CachedFactorizer();
        AtomicInteger atomicNum = new AtomicInteger(1000);
        ConcurrentUtil.run(10, 20, () -> {
            int num = atomicNum.getAndIncrement();
            if (num % 2 == 0) {
                num = 1000;
            }
            List<Integer> factors = factorizer.service(num);
            if (num == 1000) {
                System.out.println(num + " factors = " + factors);
            }
        });
    }
}
