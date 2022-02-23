package cs108;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class BoundedIntQueueTest {
    @Test
    void testNegativeArgInConstructor(){
        assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIntQueueBuggy2(-1);
        });
    }

    @Test
    void testZeroArgInConstructor(){
        new BoundedIntQueueBuggy2(0);
        //No Exception
    }

    @Test
    void testCapacity(){
        BoundedIntQueueBuggy2 b = new BoundedIntQueueBuggy2(2);
        int expected = 2;
        int real = b.capacity();
        assertEquals(expected, real);
    }

    @Test
    void testDefaultSize(){
        BoundedIntQueueBuggy2 b = new BoundedIntQueueBuggy2(0);
        int expected = 0;
        int real = b.size();
        assertEquals(expected, real);
    }

    @Test
    void testSizeAfterAddingAnElement(){
        BoundedIntQueueBuggy2 b = new BoundedIntQueueBuggy2(1);
        b.addLast(1);
        int expected = 1;
        int real = b.size();
        assertEquals(expected, real);
    }

    @Test
    void testIsFullWithNoElementCapacityZero(){
        BoundedIntQueueBuggy2 b = new BoundedIntQueueBuggy2(0);
        boolean expected = true;
        boolean real = b.isFull();
        assertEquals(expected, real);
    }

    @Test
    void testIsFullWithNoElementCapacityOne(){
        BoundedIntQueueBuggy2 b = new BoundedIntQueueBuggy2(1);
        boolean expected = false;
        boolean real = b.isFull();
        assertEquals(expected, real);
    }

    @Test
    void testAddLastWhenCapacityZero(){
        BoundedIntQueueBuggy2 b = new BoundedIntQueueBuggy2(0);
        assertThrows(IllegalStateException.class, () -> {
           b.addLast(2);
        });
    }

    @Test
    void testAddLastWhenCapacityOne(){
        BoundedIntQueueBuggy2 b = new BoundedIntQueueBuggy2(1);
        b.addLast(2);
        //No error expected;
    }

    @Test
    void testRemoveFirstWithNoElement(){
        BoundedIntQueueBuggy2 b = new BoundedIntQueueBuggy2(1);
        assertThrows(IllegalStateException.class, () -> {
            b.removeFirst();
        });
    }

    @Test
    void testRemoveFirstWithOneElement(){
        BoundedIntQueueBuggy2 b = new BoundedIntQueueBuggy2(1);
        b.addLast(2);
        int expected = 2;
        int real = b.removeFirst();
        assertEquals(expected, real);

        expected = 0;
        real = b.size();
        assertEquals(expected, real);
    }
























}