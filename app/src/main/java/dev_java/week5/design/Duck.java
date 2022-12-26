package dev_java.week5.design;
/*
 * 추상클래스
 * 단독으로 인스턴스화 할 수 없다. 반드시 구현체 클래스 있어야 함. 메소드 오버라이딩
 * 인터페이스가 추상클래스 보다 더 추상적이다 - 생성자 일반메소드도 갖음 -> 그러니까 덜 추상적임
 * 생성자는 전역변수의 디폴트 값을 결정 할 수 있으니까...
 */

public abstract class Duck {																									
	// 인터페이스 - 날다, 날지 못한다
    FlyBehavior flyBehavior;																								
	// 인터페이스 - 무음 MuteQuak, 삐~이익 Squak, 꽥꽥 Quack
    QuackBehavior quackBehavior;																								
	// 생성자
    public Duck(){}
	public abstract void display();																								
	public void performFly(){		
        // FlyWithWings.java, FlyNoWay.java
        // 추상메소드이다. -> Override가 필요하다 -> 구현체 클래스가 필요하다																						
		flyBehavior.fly();																							
	}																								
	public void performQuack(){																								
		quackBehavior.quack();																							
	}																								
	public void swimming(){																								
		System.out.println("모든 오리는 물위에 뜬다");																							
	}   																								
}																									
