package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FibonacciTest {
    @Test
    void should_return_1_when_calculate_given_position_is_1() {
        //given
        Fibonacci fibonacci = new Fibonacci();
        //when
        long result = fibonacci.calculate(1);
        //then
        Assert.assertEquals(1, result);
    }

    @Test
    void should_return_3_when_calculate_given_position_is_4() {
        //given
        Fibonacci fibonacci = new Fibonacci();
        //when
        long result = fibonacci.calculate(4);
        //then
        Assert.assertEquals(3, result);
    }

    @Test
    void should_return_8_when_calculate_given_position_is_6() {
        //given
        Fibonacci fibonacci = new Fibonacci();
        //when
        long result = fibonacci.calculate(6);
        //then
        Assert.assertEquals(8, result);
    }

    @Test
    void should_return_12586269025L_when_calculate_given_position_is_50() {
        //given
        Fibonacci fibonacci = new Fibonacci();
        //when
        long result = fibonacci.calculate(50);
        //then
        Assert.assertEquals(12586269025L, result);
    }
}
