package dev_java.week5.d221230.exam;

import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫번째 : ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("두번째 : ");
        int num2 = Integer.parseInt(sc.nextLine());
        // ㅇㅇ
        try {
            System.out.println("두 수의 나눗셈 결과: " + num1/num2);
            
        } catch (ArithmeticException e) {
            System.out.println("부적절한 나눗셈을 시도하였습니다.");
        }
    }
}

