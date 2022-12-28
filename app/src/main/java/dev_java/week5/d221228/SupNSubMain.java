package dev_java.week5.d221228;

class Sup {
    Sup() {
        // m();
    }

    public void m() {
        System.out.println("Sup m()호출");
    }
}

class Sub extends Sup {
    Sub() {
        super.m();
    }

    @Override // 재정의
    public void m() {
        System.out.println("Sub m()호출");
    }
}

public class SupNSubMain {
    public static void main(String[] args) {
        // insert here
        Sup sup = new Sup();
        sup.m();
        System.out.println("=====================");
        Sub sub = new Sub();
        sub.m();
        System.out.println("=======다형성========");

        // 다형성
        // 선언부(Sup) = 생성부(Sub)
        // 부모클래스의 메소드는 shadow메소드(은닉)
        Sup sp = new Sub();
        sp.m();

        System.out.println("=======형변환========");
        sub = (Sub) sup; // sub = new Sup();
        sub.m();
        int i = (int) 23.5d;
    }
}
