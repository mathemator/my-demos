package ru.mathemator.demo.javahistory.java1_2.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add(new Integer(5));
        list.add("abc");

        Map map = new HashMap();
        map.put(list.get(0), list.get(1));
    }
}
