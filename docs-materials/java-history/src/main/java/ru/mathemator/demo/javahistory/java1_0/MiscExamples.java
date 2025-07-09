package ru.mathemator.demo.javahistory.java1_0;

import java.util.Hashtable;

public class MiscExamples {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("Бублик", "Кот");
        System.out.println("Бублик это " + hashtable.get("Бублик"));

        System.out.println("Min abs: " + Math.abs(Integer.MIN_VALUE));
        System.out.println("Min + 1 abs: " + Math.abs(Integer.MIN_VALUE + 1));

        int i = Integer.parseInt("100", 2);
        System.out.println("100 is " + i);
    }
}
