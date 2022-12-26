package dev_java.week4.d221222;

import java.util.Arrays;

public class ArrayCopy11 {
    public static void main(String[] args) {
        ArrayCopy1 aCopy1 = new ArrayCopy1();

        System.out.println(Arrays.toString(aCopy1.fruit2));
        System.out.println(Arrays.toString(aCopy1.fruit));

        aCopy1.fruit2 = new String[]{"파인애플", "키위"};
        System.out.println(aCopy1.fruit2[1]);

        // ac1.ArrayCopy1();
    }
}
