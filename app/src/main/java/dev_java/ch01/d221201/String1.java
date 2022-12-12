package dev_java.ch01.d221201;

public class String1 {
     String s1 = "안녕";
     String s2 = "안녕";
     // 주소번지가 가리키는 값을 비교하려면 equals라는 메소드를 찾아볼것
     String s3 = new String("안녕");
     String s4 = new String("안녕");
     // insert here
     // s1와 s2의 주소번지는 같다? 참|거짓
     // s3와 s4의 주소번지는 같다? 참|거짓
     // 만일 s3이 가리키는 문자열이 s4와 같은지 비교하려면 어떻게 해야하나

     public static void main(String[] args) {
          String1 str = new String1();

          System.out.println("\nstr.s1 값의 해시코드는 " + str.s1.hashCode());
          System.out.println("str.s2 값의 해시코드는 " + str.s1.hashCode());
          System.out.println("str.s3 값의 해시코드는 " + str.s3.hashCode());
          System.out.println("str.s4 값의 해시코드는 " + str.s4.hashCode());

          System.out.println("\n주소를 가지고 비교");
          System.out.println("s1 == s2 : " + (str.s1 == str.s2));
          System.out.println("s3 == s4 : " + (str.s3 == str.s4));

          System.out.println("\n값를 가지고 비교");
          System.out.println("s1 == s2 : " + str.s1.equals(str.s2));
          System.out.println("s3 == s4 : " + str.s3.equals(str.s4));

          System.out.println("\n========");

          System.out.println("\n변수, 객체 주소 출력");
          System.out.println("s1 : " + System.identityHashCode(str.s1));
          System.out.println("s2 : " + System.identityHashCode(str.s2));
          System.out.println("s3 : " + System.identityHashCode(str.s3));
          System.out.println("s4 : " + System.identityHashCode(str.s4));
     }

}
