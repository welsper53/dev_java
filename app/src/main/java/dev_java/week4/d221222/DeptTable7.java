// 2022-12-19

package dev_java.week4.d221222;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.util.Arrays;
import java.util.Vector;

public class DeptTable7 extends JFrame implements ActionListener { // DeptTable7 is a JFrame
    // 선언부
    // 파라미터의 this는 DeptTable7타입이고 main에서 호출된 생성자로
    // 현재 메모리에 로딩 중인 그 객체를 가리킨다.
    // 왜 this를 넘겨야 하나요? 입력할 건데..
    // -> JTable7Dialog에서 부서번호, 부서명, 지역을 입력한 후 저장버튼을 누르면
    // Vector<String[]>추가하고 추가된 로우를 포함하는 Vector가 부모창에
    // 새로 리프레시(재사용되어야함<-이건 부모클래스에 구현함) 되어야 하니까... 호출해야한다
    JTable7Dialog jtd7 = new JTable7Dialog(this);

    String header[] = { "부서번호", "부서명", "지역" };
    String datas[][] = new String[0][3];

    DefaultTableModel dtm_dept = new DefaultTableModel(datas, header); // 생성자 호출
    JTable jtb_dept = new JTable(dtm_dept);
    JScrollPane jsp_dept = new JScrollPane(jtb_dept, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JPanel jp_north = new JPanel();
    JButton jbtn_sel = new JButton();
    JButton jbtn_ins = new JButton("입력");
    JButton jbtn_upd = new JButton("수정");
    JButton jbtn_del = new JButton("삭제");
    JButton jbtn_det = new JButton("상세보기");
    static Vector<DeptVO> vdata = new Vector<>();

    // vdata.size() = 0;
    // static Vector<String[]> vdata = new Vector<>();

    String sts = "";

    // 생성자
    public DeptTable7() {
        initDisplay();
    }

    // 화면그리기
    public void initDisplay() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 창모서리 X버튼 닫기 처리

        jp_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jbtn_ins.setBackground(new Color(60, 79, 89));
        jbtn_ins.setForeground(Color.WHITE);
        jbtn_upd.setBackground(new Color(7, 84, 170));
        jbtn_upd.setForeground(Color.WHITE);
        jbtn_det.setBackground(new Color(128, 33, 255));
        jbtn_det.setForeground(Color.WHITE);
        jbtn_del.setBackground(new Color(255, 155, 0));
        jbtn_del.setForeground(Color.WHITE);
        jbtn_sel.setText("조회");
        jbtn_sel.setForeground(Color.WHITE);
        jbtn_sel.setBackground(new Color(255, 33, 90));

        jp_north.add(jbtn_sel);
        jp_north.add(jbtn_ins);
        jp_north.add(jbtn_upd);
        jp_north.add(jbtn_del);
        jp_north.add(jbtn_det);

        jbtn_ins.addActionListener(this);
        jbtn_upd.addActionListener(this);
        jbtn_det.addActionListener(this);
        jbtn_sel.addActionListener(this);
        jbtn_del.addActionListener(this);

        this.add("North", jp_north);
        this.add("Center", jsp_dept);
        this.setTitle("부서관리시스템_Ver1.0");
        this.setSize(500, 400);
        this.setVisible(true);
    }

    // 새로고침 - Vector에 담긴 String[] 출력하기
    // 입력, 수정 화면에서 저장 버튼 누르면 Vector에 String[] 추가하고
    // 그 다이얼로그 화면은 닫히고 부모창은 새로고침 처리한다.
    // 그러니까 다이얼로그창에서 부모클래스의 refreshData 메소드를 호출해야 한다
    // 그러니까 인스턴스화 할 때 파라미터에 this를 넘겨서 사용할 수 있도록 할 것(NullPointerException)
    public void refreshData() {
        System.out.println("refreshData 호출");
        // 입력, 수정 전에 조회된 정보는 삭제함
        while (dtm_dept.getRowCount() > 0) {
            dtm_dept.removeRow(0);
        }
        if (DeptTable7.vdata.size() <= 0) {
            JOptionPane.showMessageDialog(this, "조회결과가 없습니다.", "WARN", JOptionPane.WARNING_MESSAGE);
            return; // refreshData() 탈출
        }
        System.out.println("DeptTable7 : " + vdata.size());
        // 벡터의 크기만큼 반복하면서 dtm_dept 데이터셋에 String[] 추가함
        for (int i = 0; i < vdata.size(); i++) {
            DeptVO oneRow = vdata.get(i);
            Vector<Object> vone = new Vector<>();
            vone.add(oneRow.getDeptno());
            vone.add(oneRow.getDname());
            vone.add(oneRow.getLoc());
            dtm_dept.addRow(vone);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object obj = e.getSource();

        // 너 조회버튼 누른거야?
        if (obj == jbtn_sel) {
            refreshData();
        }

        // 너 입력버튼 누른거야?
        else if (obj == jbtn_ins) {
            System.out.println("입력버튼");
            jtd7.isOk = false;
            // int index = jtb_dept.getSelectedRow();
            jtd7.set("입력", true, null, true);
        }

        // 너 수정 하려고?
        else if (obj == jbtn_upd) {
            System.out.println("수정버튼");
            jtd7.isOk = false;
            // 어떤 로우를 수정 할거니?
            // JTable목록에서 선택한 로우의 index를 값을 가져옴
            int index = jtb_dept.getSelectedRow();
            // 데이터셋 객체로 벡털르 사용 중이니 벡터에서 꺼낸 값을 String[] 초기화
            // 테이블의 양식 폼인 JTable 이벤트로 얻어옴
            DeptVO pdVO = vdata.get(index);
            System.out
                    .println("dno : " + pdVO.getDeptno() + ", dname : " + pdVO.getDname() + ", loc : " + pdVO.getLoc());
            jtd7.set("수정", true, pdVO, true);
        }

        // 너 삭제 하려고?
        else if (obj == jbtn_del) {
            System.out.println("삭제버튼");
            // 어떤 로우를 수정 할거니?
            // JTable목록에서 선택한 로우의 index를 값을 가져옴
            int index = jtb_dept.getSelectedRow();

            // -1은 end of file의미; 끝까지 찾았는데 없다
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "삭제할 부서를 선택하세요.", "WARN", JOptionPane.WARNING_MESSAGE);
            }
            vdata.remove(index);
            refreshData();
        }

        // 너 상세보기 원해?
        else if (obj == jbtn_det) {
            System.out.println("상세보기버튼");
            // 어떤 로우를 상세보기 할거니?
            // JTable목록에서 선택한 로우의 index를 값을 가져옴
            int index = jtb_dept.getSelectedRow();

            // -1은 "end of file" 의미; 끝까지 다 찾았는데 없다
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "상세보기 할 것을 선택하세요.", "WARN", JOptionPane.WARNING_MESSAGE);
                // actionPerformed 탈출
                return;
            }

            if (vdata.size() <= 0) {
                JOptionPane.showMessageDialog(this, "조회결과가 없습니다.", "WARN", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // 데이터셋 객체로 벡터를 사용 중이니 벡터에서 꺼낸 값을 DeptVO 초기화
            // 테이블의 양식 폼인 JTable 이벤트로 얻어옴
            DeptVO pdVO = vdata.get(index);
            // String[] oneRow = vdata.get(index);
            jtd7.set("상세보기", true, pdVO, false);
        }

    }

    public static void main(String[] args) {
        new DeptTable7();
    }
}
