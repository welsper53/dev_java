package dev_java.nansuGame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class RandomGameView {
    // 선언부
    JFrame jf_game = new JFrame();
    JPanel jp_east = new JPanel();
    JButton jbtn_new = new JButton("새게임");
    JButton jbtn_dap = new JButton("정답");
    JButton jbtn_clear = new JButton("지우기");
    JButton jbtn_exit = new JButton("종료");

    // 생성자

    // 파라미터가 없는 생성자를 디폴트 생성자라 한다
    // 디폴트 생성자는 생략 가능하다.
    public RandomGameView() {
        // 화면을 그리는 메소드 호출하기 위해서 선언했다.
        // 생성자 안에 있는 메소드이므로 인스턴스화 없이 가능하다
        initDisplay();
    }

    // 화면그리기 구현
    private void initDisplay() {
        // 동쪽에 붙일 속지의 레이아웃을 설정한다
        // 메소드(setLaydout)의 파라미터(new GridLayout(4,1))로 객체를 생성한다
        // -> 재사용할 필요가 없기 때문에
        // 메소드 호출 시 파라미터로 객체생성구문 가능하다
        jp_east.setLayout(new GridLayout(4, 1));
        // <=> GridLayout layout = new GridLayout(4,1); jp_east.setLayout(layout);

        jp_east.add(jbtn_new);
        jp_east.add(jbtn_dap);
        jp_east.add(jbtn_clear);
        jp_east.add(jbtn_exit);
        jf_game.add("East", jp_east);
        jf_game.setSize(450, 400); // 가로, 세로
        jf_game.setVisible(true); // 출력

    }

    // 메인 메소드
    public static void main(String[] args) {
        // 생성자 호출하기 - 디폴트 생성자가 호출됨
        new RandomGameView();
    }

}
