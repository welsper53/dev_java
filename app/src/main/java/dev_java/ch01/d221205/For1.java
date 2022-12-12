package dev_java.ch01.d221205;

public class For1 {
   public static void main(String[] args) {
      for (int i=1; i<=3; i++) {    // for문 안에 선언한 변수는 for문 안에서만 사용가능하다
         System.out.println(i);
      }

      int i=0;
      while (i<=3) {
         System.out.println(i);
         // while문 사용시에는 조건식에 사용된 변수의 증감연산자가 있는지 반드시 확인할 것.
         i++;
      }


   }
}
