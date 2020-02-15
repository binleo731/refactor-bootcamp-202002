package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FibonacciTest {
    @Test
    void should_return_1_when_calculate_given_position_is_1() {
        //given
        Fibonacci fibonacci = new Fibonacci(1);
        //when
        long result = fibonacci.calculate();
        //then
        Assert.assertEquals(1, result);
    }

    @Test
    void should_return_3_when_calculate_given_position_is_4() {
        //given
        Fibonacci fibonacci = new Fibonacci(4);
        //when
        long result = fibonacci.calculate();
        //then
        Assert.assertEquals(3, result);
    }
}
