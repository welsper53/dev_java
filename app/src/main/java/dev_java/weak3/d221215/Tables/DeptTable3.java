package dev_java.weak3.d221215.Tables;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

// ActionListener - 인터페이스 -> 단독으로 인스턴스화가 불가함 
// => 구현체 클래스가 필요함
// 추상클래스를 선언하고 있다.
// ActionListener al = new DeptTable3(); 선언부와 생성부가 다를 수 있다 
// -> 이럴때만 다형성이 가능함
// 선언부와 생성부가 다르다 - 동일한 메소드를 호출했는데 다른 기능이 처리되었다???
// 추상클래스도 구현체 클래스가 필요하다 -> this
// 예) Duck myDuck = new WoodDuck();    myDuck.fly();
//     Duck herDuck = new RubberDuck(); herDuck.fly();
//     Duck himDuck = new MallarDuck(); himDuck.fly();
public class DeptTable3 extends JFrame implements ActionListener { // DeptTable1 is a JFrame
    // 선언부
    String header[] = { "부서번호", "부서명", "지역" };
    String datas[][] = new String[0][3];
    String[][] depts = {
            { "10", "개발부", "판교" }, { "20", "경영부", "서울" }, { "30", "영업부", "수원" } };

    DefaultTableModel dtm_dept = new DefaultTableModel(datas, header); // 생성자 호출
    JTable jtb_dept = new JTable(dtm_dept);
    JScrollPane jsp_dept = new JScrollPane(jtb_dept, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JPanel jp_north = new JPanel();
    JButton jbtn_sel = new JButton();
    JButton jbtn_ins = new JButton("생성");
    JButton jbtn_upd = new JButton("수정");
    JButton jbtn_del = new JButton("삭제");

    // 생성자
    public DeptTable3() {
        initDisplay();
    }

    // 화면그리기
    public void initDisplay() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 창모서리 X버튼 닫기 처리

        jp_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jbtn_sel.setText("조회");
        jbtn_sel.setBackground(new Color(158, 9, 90));
        jbtn_sel.setForeground(Color.WHITE);
        jbtn_ins.setBackground(new Color(18, 19, 9));
        jbtn_ins.setForeground(Color.WHITE);
        jbtn_upd.setBackground(new Color(7, 84, 170));
        jbtn_upd.setForeground(Color.WHITE);
        jbtn_del.setBackground(new Color(58, 9, 9));
        jbtn_del.setForeground(Color.WHITE);

        jp_north.add(jbtn_sel);
        jp_north.add(jbtn_ins);
        jp_north.add(jbtn_upd);
        jp_north.add(jbtn_del);

        jbtn_sel.addActionListener(this);
        jbtn_ins.addActionListener(this);
        jbtn_upd.addActionListener(this);
        jbtn_del.addActionListener(this);

        this.add("North", jp_north);
        this.add("Center", jsp_dept);
        this.setTitle("부서관리시스템_Ver1.0");
        this.setSize(500, 400);
        this.setVisible(true);

    }

    // 메인메소드
    public static void main(String[] args) {
        new DeptTable3();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == jbtn_sel) {
            System.out.println("조회 버튼 클릭");
            while (dtm_dept.getRowCount() > 0) {
                dtm_dept.removeRow(0);
            }

            for (int i = 0; i < depts.length; i++) {
                Vector<Object> oneRow = new Vector<>();
                oneRow.add(depts[i][0]);
                oneRow.add(depts[i][1]);
                oneRow.add(depts[i][2]);
                dtm_dept.addRow(oneRow);
            }

            for (int i = 0; i < depts.length; i++) {
                for (int j = 0; j < depts[i].length; j++) {
                    // System.out.print(depts[i][j] + " "); // In을 빼서 3개 출력하고 줄바꿈처리
                    // System.out.println(dtm_dept.getValueAt(i, j));
                    System.out.print(depts[i][j] + " ");
                }
                System.out.println();
            }
            // DefaultTableModel에 데이터 초기화 하기
        }

        else if (obj == jbtn_ins) {
            System.out.println("생성 버튼 클릭");
            String[] imsi = { "", "", "" };

            Vector<Object> oneRow = new Vector<>();
            oneRow.add(imsi[0]);
            dtm_dept.addRow(oneRow);

        }

        else if (obj == jbtn_upd) {
            System.out.println("수정 버튼 클릭");
            String[][] imsi = new String[dtm_dept.getRowCount()][dtm_dept.getColumnCount()];

            for (int i = 0; i < dtm_dept.getRowCount(); i++) {
                for (int j = 0; j < dtm_dept.getColumnCount(); j++) {
                    imsi[i][j] = (String)(dtm_dept.getValueAt(i, j));
                }
            }
            depts = imsi;

            for (int i = 0; i < depts.length; i++) {
                for (int j = 0; j < depts[i].length; j++) {
                    System.out.print(depts[i][j] + " ");
                }
                System.out.println();
            }
        }

        else if (obj == jbtn_del) {
            System.out.println("삭제 버튼 클릭");

            int index = jtb_dept.getSelectedRow();
            System.out.println(index);

            if (dtm_dept.getValueAt(index, 0) != "") {
                Integer deptno = Integer.parseInt((String) dtm_dept.getValueAt(index, 0));
                System.out.println(deptno);
            } else
                System.out.println("null값");

            dtm_dept.removeRow(index);

        }

    }

}
