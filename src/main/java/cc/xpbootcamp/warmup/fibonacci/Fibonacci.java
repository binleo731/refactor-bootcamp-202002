package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

    long calculate(int position) {
        long[] result = new long[51];
        for (int i = 1; i <= position; i++) {
            if (i == 1 || i == 2) {
                result[1] = 1;
                result[2] = 1;
            }
            if (i > 2) {
                result[i] = result[i - 1] + result[i - 2];
            }
        }
        return result[position];
    }
}
