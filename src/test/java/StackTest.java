import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
class StackTest {



    static Stack s ;
    @BeforeEach
     void setUp(){
        s = new Stack();
    }


    @Test
    void pushShouldAddElementToStackHead  () throws NoSuchFieldException, IllegalAccessException {

       // in here I did a white box test ,  knowing the source code
        // where I exploited the  class attributes
        Stack stack =  new Stack();
        stack.push(12);
        stack.push(15);
        final Field topField = Stack.class.getDeclaredField("top");
        topField.setAccessible(true); // This line enables access to the private field
        int topValue = (int) topField.get(stack);

        final Field arrayField = Stack.class.getDeclaredField("array");
        arrayField.setAccessible(true);
        int[] array = (int[]) arrayField.get(stack);

        assertEquals(15,array[topValue]);
        stack.pop();
        topValue = (int) topField.get(stack);
        assertEquals(12,array[topValue]);

        for (int i = 0 ; i<=10 ; i++){
            stack.push(i);
        }
        topValue = (int) topField.get(stack);
        array = (int[]) arrayField.get(stack);
        assertEquals(10,array[topValue]);


    }

    @Test
    void popShouldRetireTheElementInTheHeadOfTheStack() {
        s.push(1);
        int outPut = s.pop();
        assertEquals(1,outPut);
        try {
            outPut = s.pop();
            outPut =s.pop();
        }
        catch (IllegalStateException exception){
           assertEquals("java.lang.IllegalStateException: Stack is empty",exception.toString());
        }

    }

    @Test
    void peekShouldReturnTheHeadElementWithOUtDeletingIt() throws NoSuchFieldException, IllegalAccessException {

      // white box test

        s.push(15);
        int Output = s.peek();
        assertEquals(15 , Output);

        final Field topField = Stack.class.getDeclaredField("top");
        topField.setAccessible(true); // This line enables access to the private field
        int topValue = (int) topField.get(s);

        final Field arrayField = Stack.class.getDeclaredField("array");
        arrayField.setAccessible(true);
        int[] array = (int[]) arrayField.get(s);

        assertEquals(15 , array[topValue]);


    }

    @Test
    void isEmptyShouldReturnTRueForAnEmptyStack() {
        assertTrue(s.isEmpty());

        s.push(0);
        assertFalse(s.isEmpty());

    }

    @Test
    void sizeShouldReturnTheRightSize() {
        for(int i = 0 ; i<7 ; i++){
            s.push(i);
        }
        assertEquals(7, s.size());
    }
}