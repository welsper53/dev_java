package dev_java.week5.d221226.design;

// 단독으로 인스턴스화 불가능하다
// -> 구현체 클래스가 있어야 한다
// QuackBehavior qb = new MuteQuack();
// QuackBehavior qb = new Quack();
// QuackBehavior qb = new Squeak();
public interface QuackBehavior {
    // 메소드 선언 시 추상클래스와는 다르게 abstract 예약어를 생략할 수 있다
    // -> 인터페이스는 추상만 가능하기 때문
    public abstract void quack();
    
}
