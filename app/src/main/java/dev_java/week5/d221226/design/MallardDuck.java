package dev_java.week5.d221226.design;

public class MallardDuck extends Duck{																									
	public MallardDuck() {				
		// 게으른 인스턴스화(ApplicationContext) <-> 이른 인스턴스화(BeanFactory)
		// => 스프링 수업, 전자정보프레임워크																				
		quackBehavior = new Quack();																							
		flyBehavior = new FlyWithWings();																							
	}																								
	public void display(){																								
		System.out.println("저는 물오리입니다.");																							
	}																								
}																									
