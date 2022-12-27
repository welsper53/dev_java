package dev_java.week5.d221227;

/*																									
 * main메소드 호출은 JVM에 의해 호출된다. 																									
 * JVM은 main스레드를 생성하여 main메소드를 호출한 것이다.																									
 * 따라서 프로그램을 실행할 때 main메소드가 실행되었다는 것은 main스레드가 																									
 * 수행되는 것이다.																									
 * 그리고 main안에서 사용자가 만든 새로운 스레드를 실행시켰다면 																									
 * 두 개의 스레드(main 스레드와 사용자 스레드)가 작동하고 있다는 것을 의미한다.																									
 * 																									
 * 아래 결과는 예측 불허(실행할 때마다 다를 수 있다.)																									
 * 																									
 */									

public class MainThread1_1 {		
    // 나는 스레드 클래스가 아님
    // 단 메인스레드는 가지고 있다
    // 20-21-22(main start)-23(인스턴스화-아직run호출안됨)-30(implements라서필요함상속이면필요없음)-31(start()->run():즉시 실행되지 않고 대기실에서 따짐)-69-70-71-74

	public static void main(String[] args) {																								
		System.out.println("====================================");																							
        System.out.println("main start");        																									
        Runnable r = new MyRunnableOne();   // 인터페이스 = 구현체클래스(override:run-추상메소드)
        // 코드를 조금만 수정(1달전에 코딩-코딩)하고 유지보수가 가능하다
        // 많이 손대면 손댈수록 의존관계로 인해 다른 에러를 유발시킨다

        // Thread myThread = new Thread(this); -> 컴파일에러발생
        // ==>  1) this = MainThread1_1(스레드가 아니다) 
        //      2) static 안에서는 this를 사용할 수 없다
        Thread myThread = new Thread(r);
        myThread.start();   // 디폴트 가중치는 5이다
        // try {
        //     // Thread 클래스 제공하는 메소드
        //     // 양보, 고집, 차례대로 스케줄링
        //     // 실행 대기
        //     //  - try-catch 안에 없으면 데드락 상태가 발생하여 컴파일에러 발생
        //     myThread.sleep(5000);
        //     // 실행순서 양보
        //     myThread.yield();
        //     // 실행순서 고집(양보X)
        //     myThread.join();
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }

        // Thread himTread = new MyRunnableTwo();  // 나 자신이 스레드일 때 start호출하는 방법과 아닐때 방법을 생각해야한다
        // himTread.start();   // 디폴트 가중치는 5이다 - 절대적이지 않다
        // 상속으로 처리하든 인터페이스로 처리하든 그에 따른 가중치는 없다
        // 누구든 먼저 선점하는 스레드가 우선권을 갖는다
        System.out.println("main end");								
	}																								

}																									

// Thread가 되는 방법은 두 가지가 있다
// 1) 상속
// 2) implements
// 공통점 - 둘다 run메소드를 가질 수 있다(재정의)
//          그 안에서 실행문을 처리하면 안전하다
class MyRunnableTwo extends Thread {
    @Override
    public void run() {
        System.out.println("MyRunnableTwo run호출");
    }
}

class MyRunnableOne implements Runnable{			
    @Override																						
    public void run(){																									
        System.out.println("run메소드 호출 성공");																									
        first();																									
    }																									
    public void first(){																									
        System.out.println("first메소드 호출 성공");																									
        second();																									
    }																									
    public void second(){																									
        System.out.println("second메소드 호출 성공");																									
        System.out.println("====================================");																									
    }																									
}																									


/*
 * 클래스를 상속받으면 클래스 간에 결합도가 높아진다
 * -> 재사용성이 떨어진다(오작동 경험하게 된다)
 * 기능적인 부분을 결합도를 낮추면서 테스트도 용이한 그러면서 오작동도 방지되는 방법
 *  :인터페이스 중심 코딩을 전개하는 방법
 *  -> 오버라이딩(Overriding) 중요
 */