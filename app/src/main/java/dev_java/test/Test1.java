package dev_java.test;

import java.util.Scanner;

public class Test1 {

    public void count() {
        // 로그에 출력할 값
        System.out.println("count호출");
        Scanner s = new Scanner(System.in);
        boolean isOk = false;

        while (!isOk) { // before : while(false) {
            System.out.print("문자열을 입력해주세요 : ");
            String str = s.nextLine();
            if ("exit".equals(str)) { // before : if(str == "exit") {
                // while문 탈출
                break;
            } else {
                System.out.println(str.length() + "글자 입니다.");
            }
        } // end of while
        System.out.println("요기");
        s.close();
    } // end of count()

    public void test2() {
        int i = 1;
        for (; i <= 10; i++) {
            int result = i % 3;
            switch (i % 3) {
                case 0:
                    System.out.println(i + " : 3의 배수입니다.");
                    break;
                // default:
                case 1:
                case 2:
                case 4:
                case 5:
                case 7:
                case 8:
                case 10:
                    System.out.println(i + " : 3의 배수가 아닙니다.");
            }
        }
    }

    public void test3() {
        int[] arr = new int[4];

        for (int i = 0; i <= arr.length; i++) {
            try {
                arr[i] += (10 + i);
                System.out.println(arr[i] + " ");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.toString());
            }
        }
    }

    // main method
    public static void main(String[] args) {
        // // 객체 생성
        // // 타입은 같지만 서로 다른 객체(s1!=s2)이다.
        // String s1 = new String("123");
        // String s2 = new String("123");

        // String s3 = "123";
        // String s4 = "123";

        // if (s1 == s2)
        // System.out.println("주소번지가 같니");
        // if (s1.equals(s2))
        // System.out.println("주소번지가 같니");
        // if (s3 == s4)
        // System.out.println("주소번지가 같니");
        // if (s3.equals(s4))
        // System.out.println("주소번지가 같니");

        Test1 t1 = new Test1();
        // t1.count();

        // t1.test2();

        t1.test3();

    }
}
