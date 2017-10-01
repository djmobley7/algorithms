package net.djtek.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by danmobley on 9/30/17.
 */
public class Lists {
    public static <T> List<T> getIntersection(List<T> list1, List<T> list2){
        Set<T> set = new HashSet<>();

        // iterate over smaller of the 2 lists
        if (list2.size() < list1.size()){
            //swap lists
            List<T> temp = list2;
            list2 = list1;
            list1 =  temp;
        }

        for (T element : list1){
            if (list2.contains(element)){
                set.add(element);
            }
        }

        List<T> result = new ArrayList<T>();
        result.addAll(set);
        return result;
    }
}
