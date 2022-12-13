// 2022-12-13
// ver_2: ActionListener를 AddressDialog_2.java로 이동

package dev_java.weak3.AddressBook.ver_2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.FlowLayout;


public class AddressBook_2 {
    // [선언부]
    JFrame jf_addr = new JFrame();
    AddressDialog_2 aDialog = new AddressDialog_2(this);

    // ** JPanel center
    JPanel jp_center = new JPanel();
    // ** Text Area
    JTextArea jta_diplay = new JTextArea(10,20);
    // ** JPanel North
    JPanel jp_north = new JPanel();

    // **** JButton 초기화
    JButton jbtn_sel = new JButton("조회");
    JButton jbtn_ins = new JButton("입력");
    JButton jbtn_upd = new JButton("수정");
    JButton jbtn_info = new JButton("상세보기");

    // [생성자]
    public AddressBook_2() {
        System.out.println("디폴트생성자 호출");
        initDiplay();
    }

    
    // [화면 처리부]
    private void initDiplay() {
        System.out.println("화면처리부 호출");
        // UI 종료 시 디버깅 종료
        jf_addr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // ** North 패널 설정
        jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
        // **** 패널에 버튼변수 추가
        jp_north.add(jbtn_sel);
        jp_north.add(jbtn_ins);
        jp_north.add(jbtn_upd);
        jp_north.add(jbtn_info);
        
        // JFrame에 JPanel 객체 추가
        jf_addr.add("North", jp_north);

        // ** ActionListener 호출
        jbtn_sel.addActionListener(aDialog);
        jbtn_ins.addActionListener(aDialog);
        jbtn_upd.addActionListener(aDialog);
        jbtn_info.addActionListener(aDialog);

        // JFrame 창 설정
        jf_addr.setTitle("주소록 Ver1.0");
        jf_addr.setSize(500, 450);
        jf_addr.setVisible(true);
    }

    // [메인메소드]
    public static void main(String[] args) {
        new AddressBook_2();
    }
    

}
