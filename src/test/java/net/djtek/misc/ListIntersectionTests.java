package net.djtek.misc;

import java.util.Arrays;
import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;

public class ListIntersectionTests {
    @Test
    public void getTests(){
        // one empty list
        List<Integer> list1 = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        List<Integer> list2 = Arrays.asList(new Integer[]{});
        assertEquals(0, ListIntersection.get(list1, list2).size());
        assertEquals(0, ListIntersection.get(list2, list1).size());

        // one matching element tests
        // beginning element match
        list2 = Arrays.asList(new Integer[]{1});
        List<Integer> result = ListIntersection.get(list1, list2);
        assertEquals(1, result.size());
        assertEquals(true, result.contains(1));

        result = ListIntersection.get(list2, list1);
        assertEquals(1, result.size());
        assertEquals(true, result.contains(1));

        // end element match
        list2 = Arrays.asList(new Integer[]{5});
        result = ListIntersection.get(list1, list2);
        assertEquals(1, result.size());
        assertEquals(true, result.contains(5));

        result = ListIntersection.get(list2, list1);
        assertEquals(1, result.size());
        assertEquals(true, result.contains(5));

        // middle element match
        list2 = Arrays.asList(new Integer[]{3});
        result = ListIntersection.get(list1, list2);
        assertEquals(1, result.size());
        assertEquals(true, result.contains(3));

        result = ListIntersection.get(list2, list1);
        assertEquals(1, result.size());
        assertEquals(true, result.contains(3));

        // multiple element match tests
        list2 = Arrays.asList(new Integer[]{1, 5});
        result = ListIntersection.get(list1, list2);
        assertEquals(2, result.size());
        assertEquals(true, result.contains(1));
        assertEquals(true, result.contains(5));

        list2 = Arrays.asList(new Integer[]{1, 3, 5});
        result = ListIntersection.get(list1, list2);
        assertEquals(3, result.size());
        assertEquals(true, result.contains(1));
        assertEquals(true, result.contains(3));
        assertEquals(true, result.contains(5));

        list2 = Arrays.asList(new Integer[]{0, 1, 3, 5, 7});
        result = ListIntersection.get(list1, list2);
        assertEquals(3, result.size());
        assertEquals(true, result.contains(1));
        assertEquals(true, result.contains(3));
        assertEquals(true, result.contains(5));

        // no matching element tests
        list2 = Arrays.asList(new Integer[]{6, 7, 8, 9, 0});
        result = ListIntersection.get(list1, list2);
        assertEquals(0, result.size());
    }
}
