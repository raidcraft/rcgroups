package de.raidcraft.rcgroups.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class TestIndexedSet {

    public static final int DEFAULT_SIZE = 16;

    IndexedSet<Element> set;

    @Before
    public void setup() {

        set = new IndexedSet<>(DEFAULT_SIZE);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetIDReturnsInvalidId()
    {
        Element elementNotInSet = new Element(1);

        Assert.assertEquals(IndexedSet.INVALID_ID, set.getId(elementNotInSet));
    }

    @Test
    public void testGetReturnsNull()
    {
        int idNotInSet = 7;

        Assert.assertNull(set.get(idNotInSet));
    }

    @Test
    public void testAddElement()
    {
        Element element = new Element(1);

        Assert.assertTrue(set.add(element));
        Assert.assertFalse(set.add(element));
    }

    @Test
    public void testSetElement()
    {
        Element element = new Element(1);
        int id = set.set(element);

        Assert.assertNotEquals(IndexedSet.INVALID_ID, id);
        Assert.assertEquals(id, set.set(element));
    }

    /**
     * Mock Element
     */

    private class Element {

        public int id;

        public Element(final int id) {

            this.id = id;
        }

        public String toString()
        {
            return "{ Element id: " + id + " }";
        }
    }
}
