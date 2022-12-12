package dev_java.ch01.d221205;

public class P21_1 {

   public static void main(String[] args) {
      int i = 1;
      switch (i) {
         case 0:
            ++i;     // 실행문
            break;   // switch 탈출
         case 1:
            ++i;
            break;
         default:
            ++i;
      }  // end of switch
      // insert here - i는 얼마일까요?
      System.out.println(i);
   }
}

