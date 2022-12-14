package dev_java.weak3.d221214;

class RectAngle3 {
    void RectAngle3(int params[]) {
        // 원형
        final double PI = 3.14;
        double area;

        area = PI * params[0] * params[1];

        System.out.println("원형의 면적은 " + area + "이다.");
    }

    int RectAngle3(int params[], int result) {
        // 사각형
        result = params[0] * params[1];

        return result;
    }

    double RectAngle3(double params[]) {
        // 삼각형
        params[2] = (params[0] * params[1]) / 2;

        return params[2];
    }
}

public class RectAngle3Main {
    public static void main(String[] args) {
        RectAngle3 ra3 = new RectAngle3();

        int[] in = { 2, 3};
        double[] doB = { 2, 3, 0 };
        int result = 0;

        ra3.RectAngle3(in);

        result = ra3.RectAngle3(in, result);
        System.out.println("사각형의 면적은 " + result + "이다.");

        doB[2] = ra3.RectAngle3(doB);
        System.out.println("삼각형의 면적은 " + doB[2] + "이다.");
    }
}

// 1-3. RectAngle3.class
// RectAngle3Main.class
// RectAngle3Main.class
// 배열로 처리해 보기