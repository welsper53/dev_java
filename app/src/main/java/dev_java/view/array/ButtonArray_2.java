package dev_java.view.array;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonArray_2 implements ActionListener {
    // [선언부]
    AccountSample action = new AccountSample(this);

    // setSize(400,300); 가로세로 크기 지정 setVisible(true); 윈도우창에 활성화
    JFrame jf = new JFrame();

    // JPanel center 초기화
    JPanel jp_center = new JPanel();
    // Text Area 초기화
    JTextArea jta_display = new JTextArea(10, 20);
    // Scroll Pane 초기화 (in. jta_display)
    JScrollPane jsp_display = new JScrollPane(jta_display);
    // Text Field 초기화
    JTextField jtf_input = new JTextField();
    // JPanel east 초기화
    JPanel jp_east = new JPanel();

    // JButton 초기화
    JButton jbtns[] = new JButton[4];
    String jbtn_label[] = {"새 게임", "정답", "지우기", "종료"};

    // [생성자]
    public ButtonArray_2() {
        System.out.println("디폴트생성자 호출");
        // 이벤트소스와 이벤트처리를 담당하는 핸들러클래스를 매핑하기
        // 텍스트 입력 필드 ActionListener
        jtf_input.addActionListener(this);

        // UI창 호출
        initDisplay();
    }

    // [화면그리기]
    public void initDisplay() {
        System.out.println("화면그리기 호출");
        
        // 윈도우UI 종료 시 디버깅도 같이 종료
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ** Center 패널 설정
        jp_center.setLayout(new BorderLayout());
        jp_center.add("Center", jsp_display);
        jp_center.add("South", jtf_input);

        // ** East 패널 설정
        jp_east.setLayout(new GridLayout(4, 1, 2, 2));
        // **** 패널에 버튼변수 추가
        for (int i=0; i<jbtns.length; i++) {
            jbtns[i] = new JButton(jbtn_label[i]);
            // 버튼 필드 ActionListener
            jbtns[i].addActionListener(this);
            jp_east.add(jbtns[i]);
        }
        jbtns[0].setBackground(new Color(158,9,9));
        jbtns[0].setForeground(new Color(212,212,212));
        jbtns[1].setBackground(new Color(18,90,109));
        jbtns[1].setForeground(new Color(212,212,212));
        jbtns[2].setBackground(new Color(58,19,79));
        jbtns[2].setForeground(new Color(212,212,212));
        jbtns[3].setBackground(new Color(15,9,209));
        jbtns[3].setForeground(new Color(212,212,212));

        // ** Center 패널 설정
        jp_center.setBackground(Color.green);

        // JFrame에 JPanel 객체 추가
        jf.add("Center", jp_center);
        jf.add("East", jp_east);

        // JFrame 창 설정
        jf.setSize(400, 300);
        jf.setVisible(true);
    } // end of 화면그리기



    // [메인메소드]
    public static void main(String[] args) {
        new ButtonArray_2();
    } // end of 메인메소드




    // [callBack 메소드 - ActionListener]
    @Override
    public void actionPerformed(ActionEvent e) {
        // e.getSource()는 이벤트가 감지되는 컴포넌트(JTextField)의 주소번지를 반환한다
        Object obj = e.getSource();

        // 너 새 게임할래?
        if (jbtns[0] == obj) {
            jta_display.append("♠♠♠ 새 게임을 시작합니다. ♠♠♠\n");
            jtf_input.setText("");
        }
        // 너 정답볼래?
        else if (jbtns[1] == obj) {
            jta_display.append("정답은 ??? 입니다.\n");
        }
        // 화면 좀 지워줘
        else if (jbtns[2] == obj) {
            jta_display.setText("");
        }
        // 나 그만할래
        else if (jbtns[3] == obj) {
            // 창 하나씩 끄기
            jf.dispose();
            // 애플리케이션(모든 창) 끄기
            System.exit(0);
        }
        // 너 JTextField에서 엔터친거야?
        else if (jtf_input == obj) {
            // 사용자가 텍스트 필드(jtf_input)에 입력한 문자열 읽어온다
            String input = jtf_input.getText();
            // 한 줄 씩 출력
            // jta_display.append(input + ":" + action.account2() + "\n");
            action.account2();

            // jtf_input에 엔터를 치면 입력창 초기화
            jtf_input.setText("");
        }
    }
}
