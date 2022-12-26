package dev_java.week5.design;

public class WoodDuck extends Duck{																									
    public WoodDuck(){																									
       quackBehavior = new MuteQuack();																									
       flyBehavior = new FlyNoWay();																									
    }																									
    @Override																									
    public void display() {																									
       System.out.println("나는 물오리 입니다.");																									
    }																									
 }																									
