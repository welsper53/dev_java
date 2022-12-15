package dev_java.weak3.d221215.Tables;

import java.util.Vector;

public class Vector1 {
    public static void main(String[] args) {
        Vector v = new Vector();
        Vector<String> v2 = new Vector<>();
        v2.add("안녕");
        v2.add("2");
        Vector<Integer> v3 = new Vector<>();
        Vector<DeptVO> v4 = new Vector<>(); // 3차배열 안쓴다
        // v.add(1);
        v.add("안녕");
        v.add("1");
        System.out.println(v.get(0));
        System.out.println(v.get(1));
        String insa = (String) v.get(0);
        System.out.println(insa);
        String insa2 = v2.get(0);
        System.out.println(insa2);
        if (v.get(1) instanceof Integer) {
            System.out.println("정수형");
        }
        if (v.get(1) instanceof String) {
            System.out.println("문자열");
        }

    }
}
