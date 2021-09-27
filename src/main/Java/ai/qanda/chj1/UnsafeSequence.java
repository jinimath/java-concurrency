package ai.qanda.chj1;

public class UnsafeSequence {
    private int value;

    public int getNext() {
        return value++;
    }
}
