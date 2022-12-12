package dev_java.ch01.d221201;

public class PrideMain {
     public static void main(String[] args) {
          Pride myCar = new Pride();
          Pride herCar = new Pride();
          // insert here - 아래 true가 나올 수 있게
          herCar = myCar;          // 서로 다른 주소번지가 같은 객체를 가리키게 되었다.
          System.out.println(myCar == herCar);
     }
     
}
