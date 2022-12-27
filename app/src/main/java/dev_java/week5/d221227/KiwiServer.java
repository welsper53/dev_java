package dev_java.week5.d221227;

import javax.swing.JFrame;

public class KiwiServer extends JFrame implements Runnable{
    // 선언부


    // 생성자
    public KiwiServer () {
        System.out.println("KiwiServer디폴트 생성자 호출");
    }

    public void initDisplay() {
        this.setTitle("키위톡");
        this.setVisible(true);
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // 메인메소드
    public static void main(String[] args) {
        KiwiServer ks = new KiwiServer();
        ks.initDisplay();
        Thread th = new Thread(ks);
        th.start();
    }

    @Override
    public void run() {
        // 경합이 벌어지는 일
        // 지연(대기)이 필요한 일
        
    }
}



/*
 * 관전 포인트
 * initDisplay를 메인메소드에서 호출하는 것과 생성자 안에서 호출하는 것이 가능하다
 * 그렇다면 둘의 차이는 있나? 혹은 없나?
 * 
 * 작업지시서
 * 키위톡은 메인메소드에서 initDisplay호출
 * 바나나톡은 생성자에서 initDisplay 호출
 */