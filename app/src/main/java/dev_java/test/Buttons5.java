package dev_java.test;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons5 implements ActionListener {
    JFrame jtf = new JFrame();
    JButton jbtns[] = new JButton[3];
    String jbtn_label[] = new String[] { "북쪽", "서쪽", "중앙" };
    String jbtn_loc[] = new String[] { "North", "West", "Center" };

    public void initDisplay() {
        for (int i = 0; i < jbtns.length; i++) {
            jbtns[i] = new JButton(jbtn_label[i]);
            jbtns[i].addActionListener(this);
            jtf.add(jbtn_loc[i], jbtns[i]);
        }
        jtf.setSize(400, 300);
        jtf.setVisible(true);
    }

    public static void main(String[] args) {
        Buttons5 b2 = new Buttons5();
        b2.initDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 이벤트가 감지된 버튼의 주소번지 담기
        Object obj = e.getSource();
        // 이벤트가 감지된 버튼의 문자열 담기
        String command = e.getActionCommand();
        if (jbtns[0].getText().equals(command)) {
            System.out.println(jbtns[0].getText() + " 버튼 클릭");
        } else if (jbtns[1].getText().equals(command)) {
            System.out.println(jbtns[1].getText() + " 버튼 클릭");
        }
        if (jbtns[2].getText().equals(command)) {
            System.out.println(jbtns[2].getText() + " 버튼 클릭");
        }
    }
}