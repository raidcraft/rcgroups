package de.raidcraft.rcgroups.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class TestIdPool {

    public static final int DEFAULT_CAPACITY = 16;

    private IdPool pool;

    @Before
    public void setup() {

        pool = new IdPool(DEFAULT_CAPACITY);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testPop() {

        assertEquals(0, pool.size());

        assertEquals(0, pool.pop());
        assertEquals(1, pool.pop());
        assertEquals(2, pool.pop());
    }

    @Test
    public void testPutBackwards() {

        int index_zero = pool.pop();
        int index_one = pool.pop();
        int index_two = pool.pop();

        assertEquals(0, pool.size());

        pool.put(index_two);
        assertEquals(0, pool.size());

        pool.put(index_one);
        assertEquals(0, pool.size());

        pool.put(index_zero);
        assertEquals(0, pool.size());
    }

    @Test
    public void testPopAfterPutBackwards() {

        int index_zero = pool.pop();
        int index_one = pool.pop();
        int index_two = pool.pop();

        pool.put(index_two);
        pool.put(index_one);
        pool.put(index_zero);

        assertEquals(0, pool.pop());
    }

    @Test
    public void testPutForwards() {

        int index_zero = pool.pop();
        int index_one = pool.pop();
        int index_two = pool.pop();

        assertEquals(0, pool.size());

        pool.put(index_zero);
        assertEquals(1, pool.size());

        pool.put(index_one);
        assertEquals(2, pool.size());

        pool.put(index_two);
        assertEquals(0, pool.size());
    }

    @Test
    public void testPopAfterPutForwards() {

        int index_zero = pool.pop();
        int index_one = pool.pop();
        int index_two = pool.pop();

        pool.put(index_zero);
        pool.put(index_one);
        pool.put(index_two);

        assertEquals(0, pool.pop());
    }

    @Test
    public void testPartialPopAfterPutForwards()
    {
        pool.pop();
        pool.pop();
        pool.pop();

        int index_three = pool.pop();
        int index_four = pool.pop();
        int index_five = pool.pop();

        pool.put(index_three);
        pool.put(index_four);
        pool.put(index_five);

        assertEquals(index_three, pool.pop());
        assertEquals(index_four, pool.pop());
        assertEquals(index_five, pool.pop());
    }
}
