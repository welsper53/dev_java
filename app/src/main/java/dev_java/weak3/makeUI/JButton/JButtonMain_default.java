package dev_java.weak3.makeUI.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonMain_default implements ActionListener{
    // 선언부
    JFrame jf = new JFrame();
    JButton jbtn_south = new JButton("전송");
    // 생성자
    public JButtonMain_default() {
        initDisplay();
    }

    // 화면처리부
    public void initDisplay() {
        // 이벤트 소스와 이벤트 핸들러 매핑시 this를 쓸 수 있는건
        // 오직 내안에 actionPerformed가 구현되어 있을때 뿐임
        jbtn_south.addActionListener(this);
        // 윈도창 x버튼 클릭 시 자원반납 - 어플 정상종료
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add("South", jbtn_south);
        jf.setSize(300,250);
        jf.setVisible(true);
    
    }

    // 메인메소드    
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new JButtonMain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jbtn_south) {
            System.out.println(jbtn_south.getText() + "버튼클릭");
        }
        
    }
}
