package dev_java.ch01.d221130;

public class StaticExam2 {

    public static void main(String[] args) {
        StaticExam1 test1 = new StaticExam1();
        test1.methodA();

        StaticExam1 test2 = new StaticExam1();
        test2.i = 5;

        StaticExam1 test3 = new StaticExam1();
        test3.i = 3;

        System.out.println("test1.i = " + test1.i);
        System.out.println("test2.i = " + test2.i);
        System.out.println("test3.i = " + test3.i);
    }
}
