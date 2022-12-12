package dev_java.ch01.d221130;

public class Variable1 {
    int x;

    // 나는 파라미터가 없는 메소드입니다.
    // 나는 반환형이 없다.
    void methodA() {
        int i;
        i=4;
        x=i;
        System.out.println(i);
    }
    public static void main(String[] args) {
        Variable1 variable1 = new Variable1();
        
        variable1.methodA();

        System.out.println(variable1.x);

        variable1.x = 10;

    }
}
