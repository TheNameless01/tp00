import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacciNegativeShouldThrowIllegalArgumentExceptionForNegativeInput() {
        assertThrows(IllegalArgumentException.class , ()-> Fibonacci.fibonacci(-1)) ;
    }
    @Test
    void fibonacciShouldReturnZeroForZeroInput(){
        assertEquals(0 , Fibonacci.fibonacci(0));
    }

    @Test
    void fibonacciShouldReturnOneForOneInput(){
        assertEquals(1 , Fibonacci.fibonacci(1));
    }

    @Test
    void fibonacciShouldReturnCorrectOutputsForInputsGreatThanOne(){
        assertEquals(1 , Fibonacci.fibonacci(2));
        assertEquals(2 , Fibonacci.fibonacci(3));
        assertEquals(3 , Fibonacci.fibonacci(4));
    }


}