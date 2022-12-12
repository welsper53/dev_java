package dev_java.ch01.d221205;

class P21 {
   void methodA(int i, int j) {  // call by value - 지변의 값은 호출될 때 결정된다.
      j = ++i;
      System.out.println("i = " + i + " j = " + j);
   }
   void methodB(int i, int j) {  // call by value - 지변의 값은 호출될 때 결정된다.
      j *= i;
      System.out.println("i = " + i + " j = " + j);
   }
}
public class Test {
   
   public static void main(String[] args) {
      P21 p21 = new P21();
      p21.methodA(1, 2);
      p21.methodB(1, 2);
      int i = 1;
      int j = i++;

      System.out.println("i = " + i + " j = " + j);

   }
}
