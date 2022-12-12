package dev_java.weak3.makeUI.JTextArea;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUI implements ActionListener {
    // 선언부
    JTextAreaUILogic jtaUILogic = new JTextAreaUILogic(this);
    JFrame jf = new JFrame();//인자를 받지 않는 디폴트생성자를 만들어라 By JVM
    JTextArea jta = new JTextArea(10, 20);
    JTextField jtf = new JTextField(10);
    public JTextAreaUI() {//생성자
        initDisplay();//메서드호출
    }//생성자를 만들어서 (초기화 바로 해주니까) 초기화 따로 하지않고
    //인자값을 넣는다
    public void initDisplay() {
        //이벤트소스와 이벤트핸들러 클래스 매핑하기(매칭)
        jtf.addActionListener(this);
        //멀티라인 작성 가능한 컴포넌트 배경색 설정
        jta.setBackground(Color.cyan);
        // JFrame은 디폴트 레이아웃이 Bordarlayout이래서 동서남북중앙배치 가능
        jf.add("Center", jta);//JTextArea 중앙에 배치
        jf.add("South", jtf);//남쪽에는 JTextField배치
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//원도우창 x버튼 클릭시 자원회수
        jf.setSize(400, 300);//윈도우창 가로 세로 조정
        jf.setVisible(true);//화면 출력
    }
    public static void main(String[] args) {//entty point
        new JTextAreaUI();//생성자 호출되고 그 안에 화면 그리는 메소드 호출
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //추상메소드의 파라미터(ActionEvent)를 통해 감지된 컴포넌트의 주소번지를 얻어오는
        //getSource메소드의 소유주
        Object obj = e.getSource();
        if (jtf == obj) {
            //JTextField에 입력한 문자열 받기
            String input = jtf.getText();
           // jta.append("JTexaAreaUI : " +input+"\n"); 로직에서 찍혀야하는데
            jtaUILogic.account(input);
            jta.setText("");
        }
    }
}