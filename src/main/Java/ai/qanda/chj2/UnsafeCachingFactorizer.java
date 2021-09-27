package ai.qanda.chj2;

import ai.qanda.util.FactorUtil;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class UnsafeCachingFactorizer {
    private final AtomicReference<Integer> lastNumber = new AtomicReference<>();
    private final AtomicReference<List<Integer>> lastFactors = new AtomicReference<>();

    public List<Integer> service(Integer num) {

        if (num.equals(lastNumber.get())) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return lastFactors.get();
        } else {
            List<Integer> factors = FactorUtil.factor(num);
            lastNumber.set(num);
            lastFactors.set(factors);
            return factors;
        }
    }
}
