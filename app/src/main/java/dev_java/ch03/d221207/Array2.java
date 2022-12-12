package dev_java.ch03.d221207;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Array2 extends Object {
    // 이른 인스턴스화
    int i[] = new int[3];       // {0, 0, 0}
    int j[] = new int[]{1,2,3};
    int x[] = {1,2,3};

    // 변수 - 원시배열 - 객체배열 - 자료구조(List, Map) - 쿠키와 세션

    public static void main(String[] args) {
        Array2 a2 = new Array2();
        System.out.println(a2.x.toString());
        // 배열 한번에 출력
        System.out.println(Arrays.toString(a2.i));
        System.out.println(Arrays.toString(a2.j));
        System.out.println(Arrays.toString(a2.x));

        for (int a=0;a<a2.j.length;a++) {
            System.out.println(a2.j[a]);
        }
        
        for (int y:a2.x) {
            for (int a=0; a<a2.j.length;a++) {
                System.out.println(a2.j[a]);
            }
            System.out.println(y);
        }
    }
}
