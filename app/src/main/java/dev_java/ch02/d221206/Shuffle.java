package dev_java.ch02.d221206;

public class Shuffle {
    public static void main(String[] args) {
        int a=3;
        int b=5;
        int imsi=0;

        System.out.printf("a = %d, b = %d\n", a, b);

        imsi=a;
        a=b;
        b=imsi;

        System.out.printf("a = %d, b = %d", a, b);
    }
}
