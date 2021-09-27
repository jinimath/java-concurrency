package ai.qanda.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ConcurrentUtil {
    public static void run(int nThreads, int loop, Runnable command) {
        ExecutorService executors = Executors.newFixedThreadPool(nThreads);

        IntStream.range(0, loop).forEach(n -> executors.execute(command));
        executors.shutdown();
    }
}
