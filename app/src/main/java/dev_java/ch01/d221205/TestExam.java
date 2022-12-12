package dev_java.ch01.d221205;
// 2022년 12월 5일 연습문제

// [문제 1]
// 1부터 10까지의 합을 구하는 프로그램을 작성하시오.
// [문제 2]
// 1부터 10까지 세면서 짝수의 합을 구하는 프로그램을 작성하시오.
// [문제 3]
// 1부터 100까지 세면서 5의 배수이면 fizz를 출력하고
// 7의 배수이면 buzz를 출력하고
// 5와 7의 공배수이면 fizzbuzz를 출력하고
// 나머지는 숫자를 출력하는 프로그램을 작성하시오.

class TTest {
   // 1부터 10까지의 합
   int sum1() {
      int sum = 0;
      // for (초기화; 조건식; 증감연산자) {
      for (int i = 1; i <= 10; i++) {
         sum += i;
      }
      return sum;
   }

   // 1부터 10까지 세면서 짝수의 합
   int sum2() {
      int sum = 0;
      for (int i = 1; i <= 10; i++) {
         if (i % 2 == 0)
            sum += i;
         System.out.println("i = " + i + ", sum = " + sum);
         // System.out.println("tot: %d, cnt : %d %n", sum, i);
      }
      return sum;
   }

   void countNum() {
      for (int i = 1; i <= 100; i++) {
         // if (i % 35 == 0)
         //    System.out.println("i = " + i + " fizzbuzz");
         // else if (i % 7 == 0)
         //    System.out.println("i = " + i + " buzz");
         // else if (i % 5 == 0)
         //    System.out.println("i = " + i + " fizz");
         // else
         //    System.out.println("i = " + i);
         
         switch (i % 35) {
            case 0:
               System.out.println("i = " + i + " fizzbuzz");
               break;
            case 7: case 14: case 21: case 28:
               System.out.println("i = " + i + " buzz");
               break;
            case 5: case 10: case 15: case 20: case 25: case 30:
               System.out.println("i = " + i + " fizz");
               break;
            default:
               System.out.println("i = " + i);
         }
      }
   }

   void countNumWhile() {
      int i = 1;

      while (i <= 100) {
         if (i % 35 == 0)
            System.out.println("i = " + i + " fizzbuzz");
         else if (i % 7 == 0)
            System.out.println("i = " + i + " buzz");
         else if (i % 5 == 0)
            System.out.println("i = " + i + " fizz");
         else
            System.out.println("i = " + i);
         i++;
      }
   }
}

public class TestExam {
   public static void main(String[] args) {
      TTest tTest = new TTest();

      // System.out.println("\n1부터 10까지의 합\n" + tTest.sum1());
      // System.out.println("\n1부터 10까지 세면서 짝수의 합");
      // System.out.println(tTest.sum2());

      System.out.println("\n[for] 5의 배수, 7의 배수, 5와7의 공배수");
      tTest.countNum();

      // System.out.println("\n[while] 5의 배수, 7의 배수, 5와7의 공배수");
      // tTest.countNumWhile();
   }

}
