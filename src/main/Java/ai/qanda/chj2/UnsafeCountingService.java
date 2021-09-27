package ai.qanda.chj2;

public class UnsafeCountingService {
    private long count = 0;

    public long service() {
        ++count;
        return count;
    }
}
