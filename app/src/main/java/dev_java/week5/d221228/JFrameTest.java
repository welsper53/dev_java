package dev_java.week5.d221228;

import javax.swing.JFrame;

public class JFrameTest extends JFrame {
    JFrameTest() {
        //// 상위클래스(JFrame)의 생성자 호출
        // super("제목");
        // 자신의 생성자(JFrameTest(String title))을 호출
        this("제목2");
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    JFrameTest(String title) {
        this.setTitle(title);
    }
    
    public static void main(String[] args) {
        new JFrameTest();
    }
}
