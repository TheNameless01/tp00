import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    void addShouldAddMatricesCorrectly() {
        Matrix matrix1 = new Matrix(3);
        matrix1.set(0, 0, 1);
        matrix1.set(0, 1, 2);
        matrix1.set(0, 2, 3);
        matrix1.set(1, 0, 4);
        matrix1.set(1, 1, 5);
        matrix1.set(1, 2, 6);
        matrix1.set(2, 0, 7);
        matrix1.set(2, 1, 8);
        matrix1.set(2, 2, 9);

        Matrix matrix2 = new Matrix(3);
        matrix2.set(0, 0, 1);
        matrix2.set(0, 1, 1);
        matrix2.set(0, 2, 1);
        matrix2.set(1, 0, 1);
        matrix2.set(1, 1, 1);
        matrix2.set(1, 2, 1);
        matrix2.set(2, 0, 1);
        matrix2.set(2, 1, 1);
        matrix2.set(2, 2, 1);

        matrix1.add(matrix2);

        assertEquals(2, matrix1.get(0, 0));
        assertEquals(3, matrix1.get(0, 1));
        assertEquals(4, matrix1.get(0, 2));
        assertEquals(5, matrix1.get(1, 0));
        assertEquals(6, matrix1.get(1, 1));
        assertEquals(7, matrix1.get(1, 2));
        assertEquals(8, matrix1.get(2, 0));
        assertEquals(9, matrix1.get(2, 1));
        assertEquals(10, matrix1.get(2, 2));
    }

    @Test
    void addShouldThrowExceptionForNullMatrix() {
        Matrix matrix = new Matrix(3);
        assertThrows(NullPointerException.class, () -> matrix.add(null));
    }

    @Test
    void addShouldThrowExceptionForDifferentMatrixSizes() {
        Matrix matrix1 = new Matrix(3);
        Matrix matrix2 = new Matrix(2);
        assertThrows(IllegalArgumentException.class, () -> matrix1.add(matrix2));
    }

    @Test
    void multiplyShouldMultiplyMatricesCorrectly() {
        Matrix matrix1 = new Matrix(2);
        matrix1.set(0, 0, 1);
        matrix1.set(0, 1, 2);
        matrix1.set(1, 0, 3);
        matrix1.set(1, 1, 4);

        Matrix matrix2 = new Matrix(2);
        matrix2.set(0, 0, 5);
        matrix2.set(0, 1, 6);
        matrix2.set(1, 0, 7);
        matrix2.set(1, 1, 8);

        matrix1.multiply(matrix2);

        assertEquals(19, matrix1.get(0, 0));
        assertEquals(22, matrix1.get(0, 1));
        assertEquals(43, matrix1.get(1, 0));
        assertEquals(50, matrix1.get(1, 1));
    }

    @Test
    void multiplyShouldThrowExceptionForNullMatrix() {
        Matrix matrix = new Matrix(3);
        assertThrows(NullPointerException.class, () -> matrix.multiply(null));
    }

    @Test
    void multiplyShouldThrowExceptionForDifferentMatrixSizes() {
        Matrix matrix1 = new Matrix(3);
        Matrix matrix2 = new Matrix(2);
        assertThrows(IllegalArgumentException.class, () -> matrix1.multiply(matrix2));
    }

    @Test
    void transposeShouldTransposeMatrixCorrectly() {
        Matrix matrix = new Matrix(3);
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(0, 2, 3);
        matrix.set(1, 0, 4);
        matrix.set(1, 1, 5);
        matrix.set(1, 2, 6);
        matrix.set(2, 0, 7);
        matrix.set(2, 1, 8);
        matrix.set(2, 2, 9);

        matrix.transpose();

        assertEquals(1, matrix.get(0, 0));
        assertEquals(4, matrix.get(0, 1));
        assertEquals(7, matrix.get(0, 2));
        assertEquals(2, matrix.get(1, 0));
        assertEquals(5, matrix.get(1, 1));
        assertEquals(8, matrix.get(1, 2));
        assertEquals(3, matrix.get(2, 0));
        assertEquals(6, matrix.get(2, 1));
        assertEquals(9, matrix.get(2, 2));
    }

    @Test
    void toStringShouldReturnStringRepresentation() {
        Matrix matrix = new Matrix(2);
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(1, 0, 3);
        matrix.set(1, 1, 4);

        String expected = "[1, 2]\n[3, 4]\n";

        assertEquals(expected, matrix.toString());
    }

}