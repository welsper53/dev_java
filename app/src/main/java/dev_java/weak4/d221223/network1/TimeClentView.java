package dev_java.weak4.d221223.network1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
// import java

public class TimeClentView extends JFrame {
    // [선언부]
    JLabel jlb_timer = new JLabel("현재시간", JLabel.CENTER);
    Font f = new Font("굴림체", Font.BOLD, 46);

    // [생성자]
    TimeClentView() {
        initDisplay();
    }

    // [화면처리부]
    public void initDisplay() {
        Thread th = new TimeClient(jlb_timer);
        th.start();
        jlb_timer.setFont(f);
        this.add("Center", jlb_timer);
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // [메인메소드]
    public static void main(String[] args) {
        new TimeClentView();
    }
}
