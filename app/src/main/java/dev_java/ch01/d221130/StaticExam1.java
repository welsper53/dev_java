package dev_java.ch01.d221130;

public class StaticExam1 {

    int i = 1;

    static int j;

    void methodA() {
        System.out.println("i:" + i);
        System.out.println("j:" + StaticExam1.j);
    }

    int methodA(int i) {
        int n = i;

        return n;
    }


    public static void main(String[] args) {
        StaticExam1 test = new StaticExam1();
        test.methodA();

        System.out.println(test.methodA(6));
    }
}
