package dev_java.ch01.d221202;

// java.lang 패키지 외 클래스들은 모두 import문을 추가해야한다.
// -> 미추가 시 ".class" 생성이 되지 않아서 컴파일 에러
// import 클래스명;
import java.util.Scanner;

// - 클래스의 구성요소 2가지 -> 함수형 프로그래밍 처리방식 -> 자바: 람다식 지원 (=일급함수, 일급객체)
//    1)명사형 = 필드, 변수
//    2)동사형 = 메소드
// - 필드 + 메소드 ==> 클래스 정의
// - 클래스를 인스턴스화 하면 메모리에 로딩이 된다(RAM에 상주한다)
// - 클래스를 인스턴스화 하는 이유 => 변수와 메소드를 호출하기 위해
//    (참조할 수 없는 이유는 컴파일 순서에서 찾을 수 있다. 
//     다른 멤버보다 static 멤버가 먼저 컴파일되기 때문에, 
//     static 멤버의 컴파일 시점에서는 static이 아닌 
//     메서드나 필드는 정의되지 않았기 때문)
// 예)인스턴스화.메소드명();
//    인스턴스화.메소드명(int i, double d, ...);
//    인스턴스화.전역변수(원시형+참조형 모두...);
// -인스턴스화 하면 복제본을 만들 수 있다 -> 객체
// - 클래스 상속 시 바로 상위 클래스를 상속해야 받을 수 있는 변수,메소드 양이 많다.

public class ScannerExam1 {
   public static void main(String[] args) {
      System.out.println("0부터 9사이의 숫자를 입력하세요.");

      // 생성자, 메소드 또는 파라미터의 갯수*타입은 반드시 지켜야한다.
      // "Scanner = java.util.Scanner"
      // 생성부의 파라미터(매개변수) 자리는 시스템의 입력장치정보
      Scanner scanner = new java.util.Scanner(System.in);

      // nextLine() : (String type), Scanner 클래스의 메소드
      String user = scanner.nextLine();
      // scan 명령문 후 종료
      scanner.close();

      // "wrapper class" : String 값을 int 형으로 변환
      // -> 원시형 변수는 참조형이 아니기 때문에 다르게 호출을 하면 값이 나오기 때문에
      // why) 원시형 타입은 변수와 메소드를 가질 수 없다.
      // 원시형 변수(type)는 호출하면 값이 출력되기 때문에 변수와 메소드를 가질 수 없다
      // 원시형 변수(type)는 직접 참조 방식이므로 값이 호출 된다.
      // 참조형 변수는 간접 참조 방식이므로 변수나 메소드를 호출,
      int i_user = Integer.parseInt(user);

      System.out.println(user + 1);
      System.out.println(i_user + 1);

   }

}
