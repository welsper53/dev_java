package dev_java.ch01.d221205;

import java.util.Scanner;

class Cal {
    // 구구단 (2~9단)
    void mul() {
        for (int i=2; i<=9; i++) {
            for (int j=1; j<=9; j++) {
                System.out.println(i + " x " + j + " = " + (i*j));
            }
            System.out.println();
        }
    }
    // 입력 받은 값으로 구구단
    void mul(int i) {
        for (int j=1; j<=9; j++) {
            System.out.printf("%d x %d = %d\n", i, j, (i*j));
        }
    }
}

public class ScanCal {
    
    public static void main(String[] args) {
        Cal cal = new Cal();

        // cal.mul();

        // 입력 받아서 구구단 출력
        Scanner scanner = new Scanner(System.in);
        System.out.printf("몇 단을 계산할지 입력 : ");
        String n = scanner.nextLine();
        scanner.close();

        int i = Integer.parseInt(n);

        cal.mul(i);

    }
}
