package cs108;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class BoundedIntQueueTest {
    @Test
    void testNegativeArgInConstructor(){
        assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIntQueueBuggy(-1);
        });
    }

    @Test
    void testZeroArgInConstructor(){
        new BoundedIntQueueBuggy(0);
        //No Exception
    }

    @Test
    void testCapacity(){
        BoundedIntQueueBuggy b = new BoundedIntQueueBuggy(2);
        int expected = 2;
        int real = b.capacity();
        assertEquals(expected, real);
    }

    @Test
    void testDefaultSize(){
        BoundedIntQueueBuggy b = new BoundedIntQueueBuggy(0);
        int expected = 0;
        int real = b.size();
        assertEquals(expected, real);
    }

    @Test
    void testSizeAfterAddingAnElement(){
        BoundedIntQueueBuggy b = new BoundedIntQueueBuggy(1);
        b.addLast(1);
        int expected = 1;
        int real = b.size();
        assertEquals(expected, real);
    }

    @Test
    void testIsFullWithNoElementCapacityZero(){
        BoundedIntQueueBuggy b = new BoundedIntQueueBuggy(0);
        boolean expected = true;
        boolean real = b.isFull();
        assertEquals(expected, real);
    }

    @Test
    void testIsFullWithNoElementCapacityOne(){
        BoundedIntQueueBuggy b = new BoundedIntQueueBuggy(1);
        boolean expected = false;
        boolean real = b.isFull();
        assertEquals(expected, real);
    }

    @Test
    void testAddLastWhenCapacityZero(){
        BoundedIntQueueBuggy b = new BoundedIntQueueBuggy(0);
        assertThrows(IllegalStateException.class, () -> {
           b.addLast(2);
        });
    }

    @Test
    void testAddLastWhenCapacityOne(){
        BoundedIntQueueBuggy b = new BoundedIntQueueBuggy(1);
        b.addLast(2);
        //No error expected;
    }

    @Test
    void testRemoveFirstWithNoElement(){
        BoundedIntQueueBuggy b = new BoundedIntQueueBuggy(1);
        assertThrows(IllegalStateException.class, () -> {
            b.removeFirst();
        });
    }

    @Test
    void testRemoveFirstWithOneElement(){
        BoundedIntQueueBuggy b = new BoundedIntQueueBuggy(1);
        b.addLast(2);
        int expected = 2;
        int real = b.removeFirst();
        assertEquals(expected, real);

        expected = 0;
        real = b.size();
        assertEquals(expected, real);
    }
























}