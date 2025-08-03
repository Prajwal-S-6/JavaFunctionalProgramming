package com.java.functional.programming.generics;

import java.util.HashMap;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("A",1);
        map.put(2, "B");
        System.out.println(map);

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        System.out.println(map1);
    }
}
