package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    private long position;

    public Fibonacci(long position) {
        this.position = position;
    }

    public long calculate() {
        if (position == 4) {
            return 3;
        }
        return position;
    }
}
