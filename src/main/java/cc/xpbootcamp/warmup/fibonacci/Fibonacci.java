package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

    private static final int MIN_INDEX = 3;
    private static final int MAX_POSITION = 51;

    long calculate(int position) {
        if (isIndexOutOfBounds(position)) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return calculateResult(position);
        }
    }

    private boolean isIndexOutOfBounds(int position) {
        return position < 1 || position >= MAX_POSITION;
    }

    private long calculateResult(int position) {
        if (position < MIN_INDEX) {
            return 1;
        }
        long[] result = new long[MAX_POSITION];
        result[1] = result[2] = 1;
        for (int i = MIN_INDEX; i <= position; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[position];
    }
}
