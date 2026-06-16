package com.chenkai;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testAdd() {
        assertEquals(13, Calculator.add(10, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(7, Calculator.subtract(10, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(30, Calculator.multiply(10, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(3.333, Calculator.divide(10, 3), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator.divide(10, 0);
    }
}
