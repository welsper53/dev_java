package dev_java.week5.d221228;

class StopThread implements Runnable {
	boolean stopped = false;		

    @Override			
	public void run() {
		while(!stopped) {	// true
			System.out.println("Thread is alive....");	// 출력
			try {	
				Thread.sleep(500);				// 0.5초 후 다시 출력 - Thread is alive...
			} catch (InterruptedException e) {
				e.printStackTrace();	
			}	
		}	// end of while문
		// 아래코드는 9, 16줄 구간 중 12줄에서 멈춰있을 때 다른 스레드가 인터셉트 가능함-다른 스레드가 있으면
		System.out.println("Thread is deaded");		
	}

	public void stop() {
		stopped = true;	
	}					
}					

public class StopThreadTest {		
	// 29(메인스레드)-31-32(메소드호출)-35-36(객체생성)-37(스레드객체생성-파라미터36줄로넘김)
	// 38-7(run콜백호출)[스레드대기자방에서 우선순위 따짐- 자기순서이면 실행 시작]-18(intercept)
	// 
	public static void main(String[] args) {		
		StopThreadTest stt = new StopThreadTest();	
		stt.process();		// stack영역
		System.out.println("main end");	// 애플리케이션(앱) 죽는다-메인스레드 회수-JVM
	}					

	public void process() {					
		StopThread st = new StopThread();	// 지역변수로 객체 생성-automatic 이영역에서만 살고죽음
		Thread th = new Thread(st);			// 스레드 생성(객체파라미터)
		th.start();		// run호출
		try {	
			Thread.sleep(1000);					
		} catch (InterruptedException e) {		
			e.printStackTrace();		
		}	
		st.stop();	
	}	
}		