package dev_java.weak3.Homework;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class StRecode {
    // [선언부]
    StRecodeLogic recodeLogic = new StRecodeLogic(this);
    JFrame jf_recode = new JFrame();

    // Panel {North} - 성적처리인원수
    JPanel jp_north = new JPanel();
    JLabel jl_memo1 = new JLabel("성적처리인원수:");
    JTextField jtf_insert = new JTextField(23);
    JLabel jl_memo2 = new JLabel("명");
    JButton jbtn_make = new JButton("만들기");

    // Panel {Center} - 결과
    JPanel jp_center = new JPanel();
    String[] header = {"이름", "국어", "영어", "수학", "총점", "평균", "석차"};
    String[][] datas;
    DefaultTableModel dtm_recode = new DefaultTableModel(datas, header);
    JTable jtb_recode = new JTable(dtm_recode);
    JScrollPane jsp_recode = new JScrollPane(jtb_recode
    , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    // Panel {South} - 버튼
    JPanel jp_south = new JPanel();
    JButton jbtn_oper = new JButton("연산");
    JButton jbtn_sam = new JButton("3명샘플");
    JButton jbtn_del = new JButton("지우기");
    JButton jbtn_exit = new JButton("종료");


    // [생성자]
    public StRecode() {
        System.out.println("defalt생성자 호출");
        initDisplay();
    }

    private void initDisplay() {
        System.out.println("GUI 호출");

        jtf_insert.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jp_north.add(jl_memo1);
        jp_north.add(jtf_insert);
        jp_north.add(jl_memo2);
        jp_north.add(jbtn_make);
        jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
        jbtn_make.addActionListener(recodeLogic);
        jtf_insert.addActionListener(recodeLogic);
        
        
        //datas.addActionListener(recodeLogic);
        jp_center.add(jsp_recode);


        jbtn_oper.addActionListener(recodeLogic);
        jbtn_sam.addActionListener(recodeLogic);
        jbtn_del.addActionListener(recodeLogic);
        jbtn_exit.addActionListener(recodeLogic);
        jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jp_south.add(jbtn_oper);
        jp_south.add(jbtn_sam);
        jp_south.add(jbtn_del);
        jp_south.add(jbtn_exit);


        // UI 종료 시 디버깅 종료
        jf_recode.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf_recode.setTitle("성적처리");
        jf_recode.add("North", jp_north);
        jf_recode.add("Center", jp_center);
        jf_recode.add("South", jp_south);
        jf_recode.setSize(470, 550);
        jf_recode.setVisible(true);
    } // end of initDisplay



    // [메인메소드]
    public static void main(String[] args) {
        new StRecode();
    }
}
