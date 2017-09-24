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
        assertEquals(3, map.size());

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

        // non-existent key
        assertNull (map.find("Four"));
    }

    @Test
    public void putTests(){
        putTests(new HashMap<>());
    }

    @Test
    public void putWithOneBucketTests(){
        // force collisions by just using 1 bucket
        putTests(new HashMap<>(1));
    }

    private void putTests(HashMap<String, Integer> map){
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
    public void removeTests(){
        removeTests(new HashMap<>());
    }

    @Test
    public void removeWithOneBucketTests(){
        // force collisions by just using 1 bucket
        removeTests(new HashMap<>(1));
    }

    private void removeTests(HashMap<String, Integer> map){
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        assertEquals(3, map.size());

        map.remove("One");
        assertEquals(2, map.size());

        // remove same key again
        map.remove("One");
        assertEquals(2, map.size());

        // remove non-existent key
        map.remove("Four");
        assertEquals(2, map.size());

        map.remove("Two");
        assertEquals(1, map.size());

        map.remove("Three");
        assertEquals(0, map.size());
    }
}