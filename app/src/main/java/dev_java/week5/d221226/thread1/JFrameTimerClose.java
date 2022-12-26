package dev_java.week5.d221226.thread1;

import javax.swing.JFrame;

public class JFrameTimerClose extends JFrame{
    public JFrameTimerClose() {
        super("JFrame테스트-3초후 창닫기");
        this.setSize(500, 500);
        this.setVisible(true);

        // 대기
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        setVisible(false);
    }

    public static void main(String[] args) {
        new JFrameTimerClose();
    }
    
}
