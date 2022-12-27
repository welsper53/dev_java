package dev_java.week5.d221227;

import javax.swing.JFrame;

public class BananaServer extends JFrame {
    String title = "야호";
    // 생성자
    BananaServer() {
        initDisplay();
    }

    BananaServer(String title) {
        // super는 상속한 부모클래스를 본다
        // 아래는 JFrame의 생성자로 되어있다 "super(title) == JFrame(title)"
        // super(title);   // 이 코드가 this.setTitle() 역할을 한다
        this.title = title;
        initDisplay();
        // 아래 this는 BananaServer를 가리키는 것이다
        // this(title); // 자기자신을 호출하기 때문에 컴파일에러
    }

    public void initDisplay() {
        // this.setTitle("바나나톡");
        this.setTitle(title);
        this.setVisible(true);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // this는 클래스 쪼개기 즉 화면과 로직의 분리
    // 또는 하나의 클래스를 여러개의 클래스로 나누어(분업) 처리할 때만 필요함
    // - 실무에서 사용할 일이 없다
    public static void main(String[] args) {
        // new BananaServer();
        // 파라미터 생성자로 title 추가했을 때 이 정보를 initDisplay에서
        // setTitle에 사용하고 싶다 어떡하지?
        // 생성자 파라미터에는 this말고도 다른 타입을 사용가능하다 - String
        new BananaServer("생성자 파라미터로 제목을 결정함 - 초기화");
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