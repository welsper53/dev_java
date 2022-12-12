package dev_java.ch03.d221207;

import java.util.Arrays;

public class Array3 {
    public static void main(String[] args) {
        int i[] = { 1, 2, 3 };
        int j[];
                
        // // 확인용
        // System.out.println(i.toString());
        // System.out.println(j.toString());

        j = i;
        // 배열 주소값 출력
        System.out.println("배열 주소값 출력");
        System.out.println(i.toString());
        System.out.println(j.toString());
        // 배열값 출력
        System.out.println("배열값 출력");
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(j));
        
        int k[];
        // 아래 에러가 발생하는 이유
        // j = k;
        // => 배열 k가 선언 후 초기화하지 않은 상태에서 대입연산자로 사용했기 때문
        // ==> (k = new int[3];) 코드를 위에 추가
        

        String s1 = "안녕";
        String s2 = s1;
        System.out.println(s1.length());

    }

}
