package ai.qanda.chj1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class UnsafeSequenceMain {
    public static void main(String[] args) {
        UnsafeSequence sequence = new UnsafeSequence();
        ExecutorService executors = Executors.newFixedThreadPool(10);

        IntStream.range(0, 10).forEach( n -> executors.execute( () -> {
            try {
                Thread.sleep(10);
                int v = sequence.getNext();
                System.out.println("v = " + v);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        executors.shutdown();
    }
}
