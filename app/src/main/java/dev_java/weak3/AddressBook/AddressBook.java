// 2022-12-13
// 주소록 만들기
package dev_java.weak3.AddressBook;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class AddressBook implements ActionListener{
    // ###### [선언부] ######
    JFrame jf_addr = new JFrame();

    // 이미지 경로 선언
    String imgPath = "D:\\vscode_java\\dev_java\\app\\src\\main\\java\\dev_java\\images\\";
    // 툴바 및 타이틀 이미지설정
    ImageIcon titleIcon = new ImageIcon(imgPath + "memo.png");
    JToolBar jtb = new JToolBar();

    // {메뉴바 구성하기}
    JMenuBar jmb = new JMenuBar();
    // * File 메뉴
    JMenu jm_file = new JMenu("File");
    JMenuItem jmi_db = new JMenuItem("DB연동확인");
    // 메뉴 아이템 분리선 추가
    JSeparator js_exit = new JSeparator();
    JMenuItem jmi_exit = new JMenuItem("종료");
    JMenuItem jmi_all = new JMenuItem("전체");
    // * Edit 메뉴
    JMenu jm_edit = new JMenu("Edit");
    JMenuItem jmi_ins = new JMenuItem("입력");
    JMenuItem jmi_upd = new JMenuItem("수정");
    JMenuItem jmi_del = new JMenuItem("삭제");
    JMenuItem jmi_read = new JMenuItem("상세보기");


    // {JPanel "North"}
    JPanel jp_north = new JPanel();
    // * JButton 초기화
    // ** 텍스트 버튼
    // JButton jbtn_all = new JButton("전체조회");
    // JButton jbtn_sel = new JButton("조회");
    // JButton jbtn_ins = new JButton("입력");
    // JButton jbtn_upd = new JButton("수정");
    // JButton jbtn_read = new JButton("상세보기");
    // ** 이미지 버튼
    JButton jbtn_del = new JButton();
    JButton jbtn_sel = new JButton();
    JButton jbtn_ins = new JButton();
    JButton jbtn_upd = new JButton();
    JButton jbtn_read = new JButton();


    // {JPanel "center"}
    // * BorderLayout 중앙에 테이블(주소록 목록) 추가하기
    JPanel jp_center = new JPanel();
    // (조회 테이블 생성)
    // * 컬럼명 (JTable Header)
    String[] header = {"번호", "이름", "H.P"};
    // * 데이터
    // JTable은 양식만 제공할 뿐이고 데이터를 담을 클래스는 별도로 필요함
    String[][] datas = new String[3][3];
    // * 테이블
    // JTable에 들어갈 실제 데이터셋을 관리할 수 있는 클래스 선언함
    // JTable에 보여지는 실제 데이터는 DefaultTableModel클래스를 통해 제어 해야 함을 의미
    DefaultTableModel dtm_addr = new DefaultTableModel(datas, header);
    // 데이터셋을 JTable 생성 시 파라미터로 매칭하기
    JTable jtb_addr = new JTable(dtm_addr);
    // (스크롤바 생성)
    // DefaultTableModel의 로우수가 많아지는 경우 스크롤바 추가해야함.
    // JScrollPane은 스크롤바를 품고 있는 일종의 속지로 생각함
    // 첫번째 파라미터는 양식을 가진 JTable이고 
    // 두번째는 수직 스크롤바 정책을
    // 세번째는 수평 스크롤바 정책을 정해 줌
    JScrollPane jsp_addr = new JScrollPane(jtb_addr
    , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    AddressDialog aDialog = new AddressDialog();
    

    // ###### [생성자] ######
    public AddressBook() {
        System.out.println("디폴트생성자 호출");
        initDiplay();
    }

    // ActionEvent
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        // 버튼 ActionListener
        if (obj==jmi_all) {    // 전체조회-검색
            String members[][] = {
                {"1", "이순신", "010-123-456"}
                , {"2", "강감찬", "010-789-123"}
                , {"3", "김춘추", "010-456-789"}
            };
            // 이미 테이블에 조회된 정보가 있는 경우 모두 삭제한다
            while(dtm_addr.getRowCount() > 0) {
                dtm_addr.removeRow(0);
            }
            for(int i=0; i<members.length; i++) {
                Vector<String> oneRow = new Vector<>();
                oneRow.add(members[i][0]);
                oneRow.add(members[i][1]);
                oneRow.add(members[i][2]);
                dtm_addr.addRow(oneRow);
            }
            // 익명 클래스 문법사용
            // -> 자바 람다식, 자바스크립트 Arrow Function 문법과 유사
            //    코틀린 문법
            jsp_addr.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener(){
                public void adjustmentValueChanged(AdjustmentEvent e) {
                    JScrollBar jsb = (JScrollBar)e.getSource();
                    jsb.setValue(jsb.getMaximum());
                }
            });
        } else if (obj==jbtn_ins) {     // 입력
            aDialog.setDialog(jbtn_ins.getText(), true);
        } else if (obj==jbtn_upd) {     // 수정
            aDialog.setDialog(jbtn_upd.getText(), true);
        } else if (obj==jbtn_read) {    // 상세보기
            aDialog.setDialog(jbtn_read.getText(), true);
        }
        
    }
    

    // ###### [화면 처리부] ######
    private void initDiplay() {
        System.out.println("화면처리부 호출");

        // {UI 단축키 설정}
        // Alt + ''
        jm_file.setMnemonic('F');
        jm_edit.setMnemonic('E');
        

        // {버튼 이미지화}
        jbtn_ins.setIcon(new ImageIcon(imgPath + "new.gif"));
        jbtn_upd.setIcon(new ImageIcon(imgPath + "update.gif"));
        jbtn_del.setIcon(new ImageIcon(imgPath + "delete.gif"));
        jbtn_read.setIcon(new ImageIcon(imgPath + "detail.gif"));
        // * 툴팁 추가
        jbtn_ins.setToolTipText("입력");
        jbtn_upd.setToolTipText("수정");
        jbtn_del.setToolTipText("삭제");
        jbtn_read.setToolTipText("상세보기");

        jtb.add(jbtn_ins);
        jtb.add(jbtn_upd);
        jtb.add(jbtn_del);
        jtb.add(jbtn_read);
        jmi_all.addActionListener(this);


        // {North 패널 설정}
        // // JPanel은 FlowLayout이 기본값인데 
        // // 사용자 정의 크기와 위치를 위해 레이아웃을 뭉갠다
        // jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
        // * 패널에 버튼 추가
        // jp_north.add(jbtn_ins);
        // jp_north.add(jbtn_upd);
        // jp_north.add(jbtn_del);
        // jp_north.add(jbtn_read);

        // * 버튼들 ActionListener
        // 이벤트소스와 이벤트핸들러 크래스 매칭
        jbtn_ins.addActionListener(this);
        jbtn_upd.addActionListener(this);
        jbtn_del.addActionListener(this);
        jbtn_read.addActionListener(this);

        // UI 종료 시 디버깅 종료
        jf_addr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf_addr.setTitle("주소록 Ver1.0");

        // jf_addr.add("North", jp_north);
        jf_addr.add("North", jtb);
        jf_addr.add("Center", jsp_addr);
    
        jmb.add(jm_file);
        jm_file.add(jmi_db);
        jm_file.add(jmi_all);
        jm_file.add(js_exit);
        jm_file.add(jmi_exit);

        jmb.add(jm_edit);
        jm_edit.add(jmi_ins);
        jm_edit.add(jmi_upd);
        jm_edit.add(jmi_del);
        jm_edit.add(jmi_read);
        
        // 팝업창 아이콘 변경
        jf_addr.setIconImage(titleIcon.getImage());

        jf_addr.setJMenuBar(jmb);
        jf_addr.setSize(500, 450);
        jf_addr.setVisible(true);
    }


    // ###### [메인메소드] ######
    public static void main(String[] args) {
        new AddressBook();
    }
}
