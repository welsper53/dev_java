package dev_java.weak3.makeUI.JTextArea;

import javax.swing.JTextArea;

// 메모리 StackOverFlow발생 - 서버가 중지된다
public class JTextAreaUILogic {
    //// 여기서 직접 인스턴스화 하면 복제본이 만들어짐 -> 망함
    //// => 복제본에 출력되기 때문
    // JTextArea jta = new JTextArea(10,20);
    //// => 11줄(JTextAreaUI jtaUI = null;)과 16줄(this.jtaUI = jTextAreaUI;) 참고!
    JTextAreaUI jtaUI = null;

    public JTextAreaUILogic(JTextAreaUI jTextAreaUI) {
        // 생성자 안에서 JTextAreaUI의 JTextArea원본과 전역변수을 초기화해주어야 한다 - 이걸 못해
        System.out.println("JTextAreaUILogic 디폴트생성자");
        this.jtaUI = jTextAreaUI;
    }

    public void account(String input) {
        // JTextAreaUI클래스에 정의된 주소번지를 사용하고 싶다. 어떡하지?
        // insert here
        System.out.println("JTextAreaUILogic account 메소드");
        jtaUI.jta.append("UI Logic: " + input + "\n");
    }

}
