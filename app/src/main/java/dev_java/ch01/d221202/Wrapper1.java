package dev_java.ch01.d221202;

public class Wrapper1 {
   
   public static void main(String[] args) {
      Integer i = new Integer(10);
      int j = i;

      System.out.println(i);     // 10
      System.out.println(j);     // 10

      // type parameter = 같은type클래스.valueOf(매개변수);
      String x = String.valueOf(j);    // 10

      String y = x;
      System.out.println(y);     // 10

      // instanceof : 객체 타입 확인 연산자
      if (y instanceof String) {
         System.out.println("y는 String 타입 입니다.");
      }
      if (i instanceof Integer) {
         System.out.println("i는 Integer 타입 입니다.");
      }

   }

}
