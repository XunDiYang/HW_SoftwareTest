// package com.yxd.tem4;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            Set<String> stringSet = new HashSet<>();
            stringSet.add("qwe");
            stringSet.add("rtz");
            stringSet.add("123");
            stringSet.add("qwea");
            stringSet.add("12334rasefasd");
            stringSet.add("asdxasd");
            stringSet.add("arfskt6734");
            stringSet.add("123121");
            stringSet.add("");
            stringSet.add("qwr");
            stringSet.add("rtzz");
            stringSet.add("1234");
            stringSet.add("qwes");
            stringSet.add("1234rasefasd");
            stringSet.add("asdxasdq");
            stringSet.add("arfskt6743");
            stringSet.add("123121 ");
            stringSet.add(" ");
            System.out.println(stringSet);
        }
    }
}