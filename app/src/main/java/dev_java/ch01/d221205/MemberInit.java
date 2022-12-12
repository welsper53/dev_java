package dev_java.ch01.d221205;

public class MemberInit {
    // 디폴트 생성자라고 부른다. -디폴트 생성자는 파라미터를 결정해줄 필요없으니 생략하면
    // JVM이 대신 생성해주어 전역변수들을 초기화 시킨다

    // 전역변수 i, hap
    int i;
    int hap;

    public MemberInit() {
        System.out.println("디폴트 생성자 호출 성공 " + i + ", " + hap); // 전역변수 i, hap이 출력
    }
    
    public MemberInit(int i, int hap) {
        System.out.println("파라미터가 두 개인 생성자 호출 성공");
        this.i = i;                                             // call by value
        this.hap = hap;
        i++;
        System.out.println("i = " + this.i + ", hap = " + this.hap);
        System.out.println("i = " + i + ", hap = " + hap);
    }

    public static void main(String[] args) {
        MemberInit mi = new MemberInit();               // 9줄 생성자 호출 - 메소드오버로딩 메카니즘 따른다
        MemberInit mi2 = new MemberInit(1, 0);   // 13줄 생성자 호출
    }
}
