package ai.qanda.chj2;

import ai.qanda.util.FactorUtil;

import java.util.List;

public class SynchronizedFactorizer {
    private Integer lastNumber;
    private List<Integer> lastFactors;

    public synchronized List<Integer> service(Integer num) {

        if (num.equals(lastNumber)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return lastFactors;
        } else {
            List<Integer> factors = FactorUtil.factor(num);
            lastNumber = num;
            lastFactors = factors;
            return factors;
        }
    }
}
