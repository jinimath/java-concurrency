package ai.qanda.util;

import java.util.ArrayList;
import java.util.List;

public class FactorUtil {
    public static List<Integer> factor(int num) {
        List<Integer> factors = new ArrayList<>();
        if (num == 0)
            return factors;

        factors.add(1);

        if (num == 1)
            return factors;

        if (num < 0)
            num *= -1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                factors.add(i);
                if (i != (num / i))
                    factors.add(num / i);
            }
        }
        factors.add(num);
        factors.sort(null);

        return factors;
    }
}
