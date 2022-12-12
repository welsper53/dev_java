package dev_java.weak3.makeUI.JTextArea;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaUI {
    // 선언부
    // this -> 나자신(JTextAreaUI)
    // JTextAreaUILogic 인스턴스화
    JTextAreaUILogic jtaUILogic = new JTextAreaUILogic(this);
    // JTextAreaUIEvent 인스턴스화
    JTextAreaUIEvent jtaUIEvent = new JTextAreaUIEvent(this);

    JFrame jf = new JFrame();
    JTextArea jta = new JTextArea(10, 20);
    JTextField jtf = new JTextField(10);

    // 디폴트생성자 선언
    // 생략 가능 -> JVM에서 대신한다
    // 인스턴스할 때 호출된다
    // 생성자도 메소드처럼 호출 가능하다, 대신 리턴타입이 없다
    public JTextAreaUI() {
        initDisplay();
    }

    // UI를 그린다
    // -> event 처리가 필요하다
    public void initDisplay() {
        // 이벤트소스와 이벤트 핸들러 클래스 매핑하기(매칭)
        // 이벤트 감지; this -> 나자신 : 이벤트 핸들러 클래스 주소번지
        jtf.addActionListener(jtaUIEvent);
        // this위치는 이벤트핸들러를 가리키는 인스턴스객체
        //jtaUIEvent.jtf.addActionListener(this);
        // 멀티라인 작성 가능한 콤포넌트 배경색 설정
        jta.setBackground(Color.cyan);
        // JFrame은 디폴트 레이아웃이 BorderLayout이라서 동,서,남,북,중앙 배치 가능
        jf.add("Center", jta);  // JTextArea는 중앙에 배치
        jf.add("South", jtf);   // JTextField는 남쪽에 배치
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 윈도창 x버튼 클릭 시 자원회수 함
        jf.setSize(400, 300);   // 윈도우창 가로 세로 크기 설정
        jf.setVisible(true);    // 화면 출력함
    }

    public static void main(String[] args) {    // 가장 먼저 호출됨 - entry point임
        new JTextAreaUI();  // 생성자 호출되고 그 안에 화면 그리는 메소드 호출 됨
    }
}