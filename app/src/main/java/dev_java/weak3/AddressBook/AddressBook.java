package dev_java.weak3.AddressBook;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBook implements ActionListener{
    // [선언부]
    JFrame jf_addr = new JFrame();
    AddressDialog aDialog = new AddressDialog();

    // JPanel center
    JPanel jp_center = new JPanel();
    // Text Area
    JTextArea jta_diplay = new JTextArea(10,20);
    // JPanel North
    JPanel jp_north = new JPanel();

    // JButton 초기화
    JButton jbtn_sel = new JButton("조회");
    JButton jbtn_ins = new JButton("입력");
    JButton jbtn_upd = new JButton("수정");
    JButton jbtn_info = new JButton("상세보기");


    // [생성자]
    public AddressBook() {
        System.out.println("디폴트생성자 호출");
        // ActionListener 호출
        jbtn_sel.addActionListener(this);
        jbtn_ins.addActionListener(this);
        jbtn_upd.addActionListener(this);
        jbtn_info.addActionListener(this);

        initDiplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if (obj==jbtn_ins) {    // 너 입력버튼 누른거야?
            aDialog.jdg.setVisible(true);
        }
        
    }
    
    // [화면 처리부]
    private void initDiplay() {
        System.out.println("화면처리부 호출");
    // UI 종료 시 디버깅 종료
        jf_addr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jbtn_sel.addActionListener(this);
        jbtn_ins.addActionListener(this);
        jbtn_upd.addActionListener(this);
        jbtn_info.addActionListener(this);
        
        // ** Nort 패널 설정
        jp_north.setLayout(new FlowLayout());
        // **** 패널에 버튼변수 추가
        jp_north.add(jbtn_sel);
        jp_north.add(jbtn_ins);
        jp_north.add(jbtn_upd);
        jp_north.add(jbtn_info);
        
        // JFrame에 JPanel 객체 추가
        jf_addr.add("North", jp_north);


        // JFrame 창 설정
        jf_addr.setTitle("주소록 Ver1.0");
        jf_addr.setSize(500, 450);
        jf_addr.setVisible(true);
        // 상단 메뉴 설정
        //jp_east.setLayout(new FlowLayout(FlowLayout(FlowLayout.LEFT, 30,40)));
    }

    // [메인메소드]
    public static void main(String[] args) {
        new AddressBook();
    }
    

}
