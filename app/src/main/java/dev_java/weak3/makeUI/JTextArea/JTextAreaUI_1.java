package dev_java.weak3.makeUI.JTextArea;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUI_1 implements ActionListener {
    // 선언부
    // this -> 나자신(JTextAreaUI)
    // JTextAreaUILogic 인스턴스화
    //JTextAreaUILogic jtaUILogic = new JTextAreaUILogic(this);
    // JTextAreaUIEvent 인스턴스화
    //JTextAreaUIEvent jtaUIEvent = new JTextAreaUIEvent(this);

    JFrame jf = new JFrame();
    JTextArea jta = new JTextArea(10, 20);
    JTextField jtf = new JTextField(10);

    // 디폴트생성자 선언
    // 생략 가능 -> JVM에서 대신한다
    // 인스턴스할 때 호출된다
    // 생성자도 메소드처럼 호출 가능하다, 대신 리턴타입이 없다
    public JTextAreaUI_1() {
        initDisplay();
    }

    // UI를 그린다
    // -> event 처리가 필요하다
    public void initDisplay() {
        // 이벤트소스와 이벤트 핸들러 클래스 매핑하기(매칭)
        // 이벤트 감지; this -> 나자신 : 이벤트 핸들러 클래스 주소번지
        jtf.addActionListener(this);
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

    // annotation - 문법제약을 갖음
    // 선언부가 일치해야한다.
    // 리턴타입은 수정할 수 없다.
    @Override
    public void actionPerformed(ActionEvent e) {
        // 추상메소드의 파라미터를 통해서 감지된 컴포넌트의 주소번지를 얻어오는
        // getSource메소드의 소유주이다.
        Object obj = e.getSource();
        // JTextField에 엔터를 친거야?
        if (jtf == obj) {
            // JTextField 입력한 문자열 받기
            String input = jtf.getText();
            jta.append("JTextAreaUI원본: " + input + "\n");
            //jtaUILogic.account(input);
            //jtf.setText("");
        }
    }
}