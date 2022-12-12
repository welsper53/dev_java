package dev_java.ch01.d221205;

public class P21_3 {
   
   public static void main(String[] args) {
      int i = 1;
      int j = 2;

      if ((i != --j) & (++i <= j)) {
         System.out.println("조건을 만족할 때");
         // insert here - i와 j값을 확인 할 수 있다|없다
         System.out.println("i = " + i + ", j = " + j);
      }
      else {
         System.out.println("조건을 만족하지 않았을 때");
      }
      // insert here -> i는 얼마?, j는 얼마?
      System.out.println("i = " + i + ", j = " + j);
   }
}
