package dev_java.weak3.d221214;

public class RectAngle {
    public static void main(String[] args) {
        // 변수 선언 2개 - 가로, 세로 길이
        // 변수 선언 1개 - 면적구하기

        int width = 2;
        int height = 3;
        int area = 0;

        area = width * height;

        System.out.println("직사각형의 면적은 " + area + "이다.");
    }
}

// 1-1. RectAngle.java
//        메인메소드 안에서 처리하기

//        문제 제기
//        원의 면적도 구하고 싶다면?

//        삼각형의 면적도 구하자고 하면?

//        사각형의 면적도 구해야 하면?


// 자바에서는 같은 이름의 메소드를 선언할 수 있다
// 단, 두가지 규칙; 하나는 메소드 오버라이딩, 하나는 메소드 오버로딩이 있다
// 두가지 규칙의 공통적은 메소드 이름이 같을때 따진다
// 오버라이딩의 경우 서로 상속관계이거나 인터페이스의 구현체의 
// 파라미터의 개수 차이로 구분 -> 오버로딩