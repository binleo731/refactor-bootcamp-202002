package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

    long calculate(long position) {
        if (position == 1 || position == 2) {
            return 1;
        }
        return calculate(position - 1) + calculate(position - 2);
    }
}
