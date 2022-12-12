package dev_java.weak3.makeUI.JTextArea.classTo3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUI2Event implements ActionListener {
    JTextAreaUI2 jUi2 = null;

    public JTextAreaUI2Event(JTextAreaUI2 jtTextAreaUI2) {
        this.jUi2 = jtTextAreaUI2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 추상메소드의 파라미터를 통해서 감지된 컴포넌트의 주소번지를 얻어오는
        // getSource메소드의 소유주이다.
        Object obj = e.getSource();
        // JTextField에 엔터를 친거야?
        if (jUi2.jtf == obj) {
            // JTextField 입력한 문자열 받기
            String input = jUi2.jtf.getText();
            jUi2.getTextArea().append("JTextAreaUI원본 : " + input + "\n");
            //jUi2.jtaUILogic.account(input);
            jUi2.jtf.setText("");
        }
    }
}
