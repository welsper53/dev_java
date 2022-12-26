package dev_java.week5.d221226.design;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        // 삑삑인지 무음인지 꽥꽥인지는 언제 누가 어디에서 결정할 수 있을까?
        // 언제? 해당 기능이 요청될때
        // 누가? 구현하고자 하는 객체가 무엇인가에 따라서 
        //      myDuck = new WoodDuck();
        //      myDuck = new RubberDuck();
        //      myDuck = new MallardDuck();
        
        System.out.println("삐~이익");
    }
    
}
