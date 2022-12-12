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

public class ButtonArray implements ActionListener {
    // [선언부]
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

    JPanel jp_east = new JPanel();

    // JButton 초기화
    JButton jbtn_new = new JButton("새 게임");
    JButton jbtn_dap = new JButton("정답");
    JButton jbtn_clear = new JButton("지우기");
    JButton jbtn_exit = new JButton("종료");

    // [생성자]
    public ButtonArray() {
        System.out.println("디폴트생성자 호출");
        // 이벤트소스와 이벤트처리를 담당하는 핸들러클래스를 매핑하기
        // 텍스트 입력 필드 ActionListener
        jtf_input.addActionListener(this);
        // 버튼 필드 ActionListener
        jbtn_new.addActionListener(this);
        jbtn_dap.addActionListener(this);
        jbtn_clear.addActionListener(this);
        jbtn_exit.addActionListener(this);

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
        jbtn_new.setBackground(Color.blue);
        jbtn_new.setForeground(Color.yellow);
        // **** 패널에 버튼변수 추가
        jp_east.add(jbtn_new);
        jp_east.add(jbtn_dap);
        jp_east.add(jbtn_clear);
        jp_east.add(jbtn_exit);

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
        new ButtonArray();
    } // end of 메인메소드




    // [callBack 메소드 - ActionListener]
    @Override
    public void actionPerformed(ActionEvent e) {
        // e.getSource()는 이벤트가 감지되는 컴포넌트(JTextField)의 주소번지를 반환한다
        Object obj = e.getSource();

        // 너 새 게임할래?
        if (jbtn_new == obj) {
            jta_display.append("♠♠♠ 새 게임을 시작합니다. ♠♠♠\n");
        }
        // 너 정답볼래?
        else if (jbtn_dap == obj) {
            jta_display.append("정답은 ??? 입니다.\n");
        }
        // 화면 좀 지워줘
        else if (jbtn_clear == obj) {
            jta_display.setText("");
        }
        // 나 그만할래
        else if (jbtn_exit == obj) {
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
            jta_display.append(input + "\n");

            // jtf_input에 엔터를 치면 입력창 초기화
            jtf_input.setText("");
        }
    } // end of ctionPerformed
}
