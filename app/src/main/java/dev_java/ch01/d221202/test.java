package dev_java.ch01.d221202;

// 자바 가상머신이 컴파일하기 위해 ~~ 'import"를 사용한다.
import java.util.Scanner;

public class test {
     public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          while (true) {
               System.out.println("문자열을 입력하세요 :  ");
               String str = scanner.nextLine();
               if (str == "exit") {
                    break;
               } else {
                    System.out.println(str.length() + " 글자 입니다.");
               }
               System.out.println("프로그램을 종료합니다.");
          }
          scanner.close();
     }// end of main
}