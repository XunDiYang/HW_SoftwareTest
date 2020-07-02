// package tem1;

// package com.yxd.tem4;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            Set<String> stringSet = new HashSet<>();
            String[] str = {"qwe","rtz","1234","123121"," "}; 
            
            stringSet.add(str[0]);
            stringSet.add(str[1]);
            stringSet.add(str[2]);
            stringSet.add(str[3]);
            stringSet.add(str[4]);
            
            System.out.println("");
    		System.out.print("The line : ");
    		System.out.print("Lines " + 11);
    		System.out.println("-" + 16);
    		System.out.println("@@Class: ");
    		System.out.println("Set");
    		System.out.println("Call method: ");
    		System.out.println("add");
    		System.out.println("Input parameters: ");
    		
    		for(int j =0;j<str.length;j++) {
    			System.out.print(str[j] + " ");
    		}
    		System.out.println();
    		System.out.println("Return Value: ");
    		System.out.println(stringSet);
    		System.out.println();
            
            System.out.println(stringSet);
        }
    }
}