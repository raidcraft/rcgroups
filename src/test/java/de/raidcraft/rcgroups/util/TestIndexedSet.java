package de.raidcraft.rcgroups.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
    public void testGetIDReturnsInvalidId() {

        Element elementNotInSet = new Element(1);

        assertEquals(IndexedSet.INVALID_ID, set.getId(elementNotInSet));
    }

    @Test
    public void testGetReturnsNull() {

        int idNotInSet = 7;

        assertNull(set.get(idNotInSet));
    }

    @Test
    public void testAddElement() {

        Element element = new Element(1);

        assertTrue(set.add(element));
        assertFalse(set.add(element));
    }

    @Test
    public void testSetElement() {

        Element element = new Element(1);
        int id = set.set(element);

        assertNotEquals(IndexedSet.INVALID_ID, id);
        assertEquals(id, set.set(element));
    }

    @Test
    public void testRemoveElementReturnsFalse() {

        Element elementNotInSet = new Element(1);

        assertFalse(set.removeElement(elementNotInSet));
    }

    @Test
    public void testRemoveIdReturnsFalse() {

        int idNotInSet = 7;

        assertFalse(set.removeId(idNotInSet));
    }

    @Test
    public void testRemoveElement() {

        List<Element> values = new ArrayList<>();
        for (int i = 0; i < 32; i++) values.add(i, new Element(i));

        for (int j = 0; j < 2; j++) {

            for (int i = 0; i < 10; i++) set.set(values.get(i));

            assertTrue(set.contains(values.get(0)));

            set.removeElement(values.get(0));

            assertFalse(set.contains(values.get(0)));
        }
    }

    @Test
    public void testRemoveId() {

        List<Element> values = new ArrayList<>();
        for (int i = 0; i < 32; i++) values.add(i, new Element(i));

        for (int j = 0; j < 2; j++) {

            for (int i = 0; i < 10; i++) set.set(values.get(i));

            assertTrue(set.contains(values.get(0)));

            set.removeId(0);

            assertFalse(set.contains(values.get(0)));
        }
    }

    /**
     * Mock Element
     */

    private class Element {

        public int id;

        public Element(final int id) {

            this.id = id;
        }

        public String toString() {

            return "{ Element id: " + id + " }";
        }
    }
}
