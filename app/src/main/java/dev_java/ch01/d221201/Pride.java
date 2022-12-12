package dev_java.ch01.d221201;

//static은 메소드 이름 앞에도 올 수 있고
// 변수명 앞에도 올 수 있다.
// 그렇다면 인스턴스화 하는 것과 뭐가 다르지?
public class Pride {
     // 변수 이름 앞에 static이 있으면 인스턴스화 없이도 호출이 가능함
     // 이 말은 같은 객체를 복제하지 않는다는 의미 포함
     static String carName = "2023년형 프라이드";

     String carColor = "흰색";
     int wheelNum = 4;

     // 에러에는 두 가지 존재
     // 문법에러, 런타임 에러(Exception)
     public static void main(String[] args) {
          // 변수 이름 앞에 static이 있으면 인스턴스화 없이도 호출이 가능함
          System.out.println(carName);  //

          //인스턴스화 라고 함 - Pride객체가 메모리 상주 -> 호출이 가능한 상태
          Pride myCar = new Pride();    // myCar를 인스턴스 변수라 한다.
          System.out.println(myCar);

          myCar.carColor = "보라색";
          myCar = null;                 // 주소번지가 가리키는 객체가 사라졌다. 그러나 타입은 남았다.
          System.out.println(myCar);

          System.out.println("===========");

          myCar = new Pride();
          System.out.println(myCar);
          //System.out.println(myCar==myCar);
          System.out.println(myCar.carColor);         // 새로운 주소번지를 갖는다

          myCar.carColor = "검정색";
          System.out.println(myCar.carColor);
     }
}