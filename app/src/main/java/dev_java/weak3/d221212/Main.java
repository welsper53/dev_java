package dev_java.weak3.d221212;

public class Main {
    int i=1;
    boolean isOK[] = new boolean[3];    // false, false, false
    public static void main(String[] args) {
        //             디폴트생성자 호출
        Sub sub = new Sub();
        // sub.j : 전역변수
        //전역변수만 인스턴스변수.변수명으로 호출 가능하다
        System.out.println(sub.j);

        sub.methodSub();
    }
}
