package dev_java.weak3.d221215.Tables;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCopy1 {
    void deepCopy() {
        int[] org = { 1, 2, 3, 4, 5 };
        int[] org_copy = Arrays.copyOf(org, 2);

        org_copy[1] = 5;

        for (int e : org) {
            System.out.println(e);
        }
        for (int e : org_copy) {
            System.out.println(e);
        }
    }
    void deepCopy2() {
        int[] org = { 1, 2, 3 };
        int[] org_copy = org.clone();

        org_copy[2] = 5;

        for (int e : org) {
            System.out.println(e);
        }
        for (int e : org_copy) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        // // 얕은 복사
        // int[] org = {1,2,3};
        // int[] org_copy = org;

        // org_copy[2] = 5;

        // for (int e : org) {
        // System.out.println(e);
        // }
        // for (int e : org_copy) {
        // System.out.println(e);
        // }

        // 깊은 복사
        ArrayCopy1 ac1 = new ArrayCopy1();
        ac1.deepCopy2();
    }
}


/*
 * 배열 복사
 * -얕은 복사
 * : 복사된 배열이나 원본 배열이 변경이 될때 서로간의 값이 같이 바뀐다.
 * -깊은 복사
 * :
 */