package dev_java.ch01.d221201;

public class Method2 {
     // void일때와 반환형이 있을 때 출력하는 방법이 다르다.
     double m1(double d) {
          return 3.5; // 상수를 반환했으니깐 3.5만 반환한다.
     }

     public static void main(String[] args) {
          Method2 method2 = new Method2();
          // 메소드 내부에 출력하는 문장이 없는 경우 외부의 메소드에서
          // 그 메소드에서 결정된 값을 출력하려면 반환형이 필요.
          double result = method2.m1(1.5);

          System.out.println(result);
     }
}
