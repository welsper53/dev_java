package dev_java.weak3.d221214;

class RectAngle2{
    void RectAngle2(int i, int j) {
        // 원형
        final double PI = 3.14;
        double area;

        area = PI * i * j;

        System.out.println("원형의 면적은 " + area + "이다.");
    }
    int RectAngle2(int i, int j, int result) {
        // 사각형
        result = i * i;

        return result;
    }
    double RectAngle2(double i, double j) {
        // 삼각형
        double area;
        area = (i * j) / 2;

        return area;
    }

}


public class RectAngle2Main {
    public static void main(String[] args) {
        RectAngle2 ra = new RectAngle2();
        
        int width = 2;
        int height = 3;
        int area = 0;
        
        double widthD = 3.5;
        double heightD = 3.5;
        double areaD = 0;

        // 값에 의한 호출(call by value)
        ra.RectAngle2(width, height);

        area = ra.RectAngle2(width, height, area);
        System.out.println("사각형의 면적은 " + area + "이다.");
        
        areaD = ra.RectAngle2(widthD, heightD);
        System.out.println("삼각형의 면적은 " + areaD + "이다.");
    }
}

// 1-2. RecAngle2.class
//        메소드 꺼낸다 - 사용자 정의 메소드 구현
//        리턴타입을 결정하자

// - void일 때
// - int일 때
// - 출력하기 - where?
// - 파라미터는 갯수를 나는 결정할 수 있다.
// - 또 파라미터의 타입도 선택할 수 있다