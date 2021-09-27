package ai.qanda.chj2;

import ai.qanda.util.FactorUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CachedFactorizer {
    private Integer lastNumber;
    private List<Integer> lastFactors;
    private long hits;
    private long cacheHits;

    public List<Integer> service(Integer num) {
        List<Integer> factors = null;
        synchronized (this) {
            ++hits;
            if (num.equals(lastNumber)) {
                ++cacheHits;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                factors = new ArrayList<>(lastFactors);
            }
        }

        if (factors == null) {
            factors = FactorUtil.factor(num);
            synchronized (this) {
                lastNumber = num;
                lastFactors = new ArrayList<>(factors);
            }
        }
        return factors;
    }
}
