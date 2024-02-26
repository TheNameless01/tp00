import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    void isPrimeReturnsFalseForValuesLessThanTWO() {
        assertFalse(Prime.isPrime(-2));
        assertFalse(Prime.isPrime(0));
    }

    @Test
    void isPrimeReturnsFalseForValuesGreatThanTwoThatAreNotPrime() {
        assertFalse(Prime.isPrime(9));
        assertFalse(Prime.isPrime(8));
        assertFalse(Prime.isPrime(10000));
    }

    @Test
    void isPrimeReturnsTrueForValuesGreatThanOneThatArePrime() {
        assertTrue(Prime.isPrime(7));
        assertTrue(Prime.isPrime(5));
        assertTrue(Prime.isPrime(109));
    }
}