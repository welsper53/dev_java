package dev_java.ch01.d221201;

class Test {
     int i;
}

public class TestClass {
     public static void method() {
          System.out.println("void");
     }

     public static int method(int i) {
          i++;
          return i;
     }

     public static double method(double d) {
          d += 1.1;
          return d;
     }

     public static String method(String str) {
          str += "ㅇㅇㅇ";
          return str;
     }

     public static void method(Test c) {
          c.i = 80;
     }

     public static void main(String[] args) {
          int i = 1;
          double d = 1.5;
          String str = "aaa";
          Test testClass = new Test();
          testClass.i = 10;

          method();
          i = method(i);
          d = method(d);
          str = method(str);
          method(testClass);

          System.out.println(i);
          System.out.println(d);
          System.out.println(str);
          System.out.println(testClass.i);
     }
}
