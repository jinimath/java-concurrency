package ai.qanda.chj2;

import java.util.concurrent.atomic.AtomicLong;

public class CountingService {
    private final AtomicLong count = new AtomicLong(0);

    public long service() {
        return count.incrementAndGet();
    }
}
