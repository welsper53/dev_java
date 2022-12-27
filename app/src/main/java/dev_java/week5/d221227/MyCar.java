package dev_java.week5.d221227;

public abstract class MyCar {
    public abstract void display();

    private int wheelNum = 0;

    public MyCar() {
        System.out.println("MyCar() 호출");
    }

    public MyCar(int wheelNum) {
        System.out.println("MyCar() 호출");
        this.wheelNum = wheelNum;
    }

    public void go() {
        System.out.println("나는 앞으로 간다");
    }
}
