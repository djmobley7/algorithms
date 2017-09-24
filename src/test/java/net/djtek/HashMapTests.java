package net.djtek;

import org.junit.Test;
import static org.junit.Assert.*;

public class HashMapTests {
    @Test
    public void clearTests(){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        assertEquals(4, map.size());

        map.clear();
        assertEquals(0, map.size());
    }

    @Test
    public void findTests(){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        Integer value = map.find("One");
        assertNotNull(value);
        assertEquals(value.intValue(), 1);

        value = map.find("Two");
        assertNotNull(value);
        assertEquals(value.intValue(), 2);

        value = map.find("Three");
        assertNotNull(value);
        assertEquals(value.intValue(), 3);

        assertNull (map.find("Four"));
    }

    @Test
    public void putTests(){
        HashMap<String, Integer> map = new HashMap<>();
        assertEquals(0, map.size());

        assertNull(map.put("One", 1));
        assertEquals(1, map.size());

        // replace
        assertNotNull(map.put("One", 1));
        assertEquals(1, map.size());

        assertNull(map.put("Two", 2));
        assertEquals(2, map.size());

        assertNull(map.put("Three", 3));
        assertEquals(3, map.size());

        // replace again
        assertNotNull(map.put("Three", 3));
        assertEquals(3, map.size());
    }

    @Test
    public void putWithSmallBucketSizeTests(){
        // create hash map with bucket size one so everything gets
        // added to the same collision list
        HashMap<String, Integer> map = new HashMap<>(1);
        assertEquals(0, map.size());

        assertNull(map.put("One", 1));
        assertEquals(1, map.size());

        // replace
        assertNotNull(map.put("One", 1));
        assertEquals(1, map.size());

        assertNull(map.put("Two", 2));
        assertEquals(2, map.size());

        assertNull(map.put("Three", 3));
        assertEquals(3, map.size());

        // replace again
        assertNotNull(map.put("Three", 3));
        assertEquals(3, map.size());
    }
}