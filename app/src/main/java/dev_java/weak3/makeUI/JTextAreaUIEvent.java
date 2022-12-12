package dev_java.weak3.makeUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUIEvent implements ActionListener {
    JTextAreaUI jtaUI = null;

    public JTextAreaUIEvent(JTextAreaUI jtTextAreaUI) {
        this.jtaUI = jtTextAreaUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 추상메소드의 파라미터를 통해서 감지된 컴포넌트의 주소번지를 얻어오는
        // getSource메소드의 소유주이다.
        Object obj = e.getSource();
        // JTextField에 엔터를 친거야?
        if (jtaUI.jtf == obj) {
            // JTextField 입력한 문자열 받기
            String input = jtaUI.jtf.getText();
            jtaUI.jta.append("JTextAreaUI원본: " + input + "\n");
            jtaUI.jtf.setText("");
        }
    }
}
