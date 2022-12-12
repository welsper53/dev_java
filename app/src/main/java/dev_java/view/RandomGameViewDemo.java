package dev_java.view;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomGameViewDemo implements ActionListener {
    // 선언부
    JFrame jf = new JFrame();
    // JButton 생성자 파라미터 : String
    JButton jbtn_north = new JButton("북쪽");
    JButton jbtn_south = new JButton("남쪽");
    JButton jbtn_east = new JButton("동쪽");
    JButton jbtn_west = new JButton("서쪽");
    JButton jbtn_center = new JButton("중앙");

    // 생성자
    public RandomGameViewDemo() {
        System.out.println("디폴트 생성자 호출 성공");
        initDisplay();
    }

    // 화면처리부
    public void initDisplay() {
        System.out.println("initDisplay 호출");
        jbtn_south.addActionListener(this);
        jbtn_west.addActionListener(this);
        jbtn_center.addActionListener(this);
        // jf.add("North", jbtn_north);
        jf.add("South", jbtn_south);
        // jf.add("East", jbtn_east);
        jf.add("West", jbtn_west);
        jf.add("Center", jbtn_center);
        jf.setSize(300, 400);
        jf.setVisible(true);

    }

    // UI API를 활용하여 공부를 하면
    // 1. 초기화를 활용할 수 있게 됨
    // 2. 생성자 역할에 대해 알게 됨
    // 3. 사용자 정의 메소드를 많이 만들어 볼 수 있음
    // 4. 파라미터와 리턴타입에 대해 확실해짐
    // 5. 전역변수와 지역변수를 구분하여 코딩을 전개하게 됨
    // 6. 클래스를 나누는 조건을 갖게 됨
    // 7. 이벤트 처리를 사전학습 할 수 있음
    // 8. 익명클래스를 활용할 수 있음 - 익명함수, arrow function 등 신 문법을 공부하는데 도움됨

    // 메인메소드
    public static void main(String[] args) {
        // 생성자 호출만 하기 -> 인스턴스 변수 재사용X
        new RandomGameViewDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 눌린 버튼의 문자열을 읽어온다
        System.out.println(e.getActionCommand());

        // 눌린 버튼의 주소번지
        // @abcd1234
        System.out.println(e.getSource());

        // 중앙, 서쪽, 남쪽
        String label = e.getActionCommand();

        if ("중앙".equals(label)) {
            System.out.println("중앙버트 클릭");
        } else if ("서쪽".equals(label)) {
            System.out.println("서쪽버튼 클릭");
        } else if ("남쪽".equals(label)) {
            System.out.println("남쪽버튼 클릭");
        }
    }
}
