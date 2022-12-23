package dev_java.weak4.d221222;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//JDialog도 디폴트가 BorderLayout임 - jp_center 를 중앙배치
public class JTable7Dialog extends JDialog implements ActionListener{
	// 선언부
    DeptTable7 deptTable7 = null;
    // 왜 null을 주는지 설명할 수 있다.
    DeptVO pdVO = null;
	int index;
	boolean isOk = false;

	JPanel jp_center = new JPanel();
	JScrollPane jsp_center = new JScrollPane(jp_center);

	JPanel jp_south = new JPanel();
	JLabel jlb_deptno = new JLabel("부서번호");
	JTextField jtf_deptno = new JTextField(10);
	JButton jbtn_check = new JButton("중복체크");
	JLabel jlb_dname = new JLabel("부서명");
	JTextField jtf_dname = new JTextField(20);
	JLabel jlb_loc = new JLabel("지역");
	JTextField jtf_loc = new JTextField(20);

	// jp_south 속지
	JButton jbtn_save = new JButton("저장");
	JButton jbtn_close = new JButton("닫기");
	JButton jbtn_sample = new JButton("자동입력");

	// 생성자
	public JTable7Dialog() {
    }
    public JTable7Dialog(DeptTable7 deptTable7) {
        this.deptTable7 = deptTable7;
        initDisplay();
    }

	// 화면그리기
	public void initDisplay() {
		jp_center.setLayout(null);
		jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));

		jlb_deptno.setBounds(20, 20, 100, 20);
		jtf_deptno.setBounds(120, 20, 100, 20);
		jbtn_check.setBounds(220,20, 120, 20);
		jlb_dname.setBounds(20, 45, 100, 20);
		jtf_dname.setBounds(120, 45, 150, 20);
		jlb_loc.setBounds(20, 70, 100, 20);
		jtf_loc.setBounds(120, 70, 150, 20);

		jp_center.add(jlb_deptno);
		jp_center.add(jtf_deptno);
		jp_center.add(jbtn_check);
		jp_center.add(jlb_dname);
		jp_center.add(jtf_dname);
		jp_center.add(jlb_loc);
		jp_center.add(jtf_loc);

        jtf_deptno.addActionListener(this);
        jbtn_check.addActionListener(this);
        jtf_dname.addActionListener(this);
        jtf_loc.addActionListener(this);
        jbtn_save.addActionListener(this);
        jbtn_close.addActionListener(this);
        jbtn_sample.addActionListener(this);

		jp_south.add(jbtn_save);
		jp_south.add(jbtn_close);
		jp_south.add(jbtn_sample);

        // setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);// 창모서리 X버튼 닫기 처리
		this.add("Center", jsp_center);
		this.add("South", jp_south);
		this.setSize(400, 360);
		this.setVisible(false);
	}

	//각 컬럼(부서집합-부서번호,부서명,지역)의 값들을설정하거나
	//읽어오는 getter/setter메소드 임
	public String getDeptno(){
		return jtf_deptno.getText();
	}
	public void setDeptno(String deptno){
		jtf_deptno.setText(deptno);
	}
	public String getDname(){
		return jtf_dname.getText();
	}
	public void setDname(String dname){
		jtf_dname.setText(dname);
	}
	public String getLoc(){
		return jtf_loc.getText();
	}
	public void setLoc(String loc){
		jtf_loc.setText(loc);
	}

    // 아래 메소드는 DeptTable7에서 호출 됨
    // actionPerformed에서 이벤트(입력,수정,상세보기)가 발생되면 호출됨
    // 메소드의 파라미터 자리는 Call by Value에 의해서 결정됨
    public void set(String title, boolean isView, DeptVO pdVO, boolean isEdit) {
        this.setTitle(title);
        this.setVisible(isView);
        this.pdVO = pdVO;
		setValue(pdVO);
        setEditable(isEdit);
    }
	
	// 입력을 위한 윈도우 설정 - 모든 값을 빈문자열로 셋팅함
	public void setEditable(boolean isEdit) {
		jtf_deptno.setEnabled(isEdit);
		jbtn_check.setEnabled(isEdit);
		jtf_dname.setEnabled(isEdit);
		jbtn_save.setEnabled(isEdit);
		jtf_loc.setEnabled(isEdit);
		jbtn_sample.setEnabled(isEdit);
	}
	
    // 이런 공통코드를 나는 작성할 수 있다.
	public void setValue(DeptVO pdVO){
		
		//입력을 위한 윈도우 설정 - 모든 값을 빈문자열로 셋팅함
		if(pdVO == null){
			System.out.println("(다이얼)pdVO == null");
			System.out.println("(다이얼)생성하기");
			setDeptno("");
			setDname("");
			setLoc("");
			
		}
		//상세조회, 수정시는 배열로 받은 값으로 셋팅함
		//부모창에서 set메소드 호출시 파라미터로 넘겨준 값으로 초기화할것.
		else{
			System.out.println("(다이얼)pdVO != null");
			System.out.println("(다이얼)부서정보 있음");
			setDeptno(String.valueOf(pdVO.getDeptno()));
			setDname(pdVO.getDname());
			setLoc(pdVO.getLoc());
			System.out.println("dno : " + pdVO.getDeptno() + ", dname : " + pdVO.getDname() + ", loc : " + pdVO.getLoc());
		}
	}//end of setValue
	
	
	
	// 메인
	public static void main(String[] args) {
		new JTable7Dialog(null);
	}
    @Override
    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        Object obj=e.getSource();
		
        if (obj == jbtn_save || obj == jtf_deptno || obj == jtf_dname || obj == jtf_loc) {
			// 생성버튼
            System.out.println("(다이얼)저장모드");
            // oneRow가 존재하면 수정모드, 그렇지 않으면 입력모드로 함
			// 다이얼로그 화면에서 저장버튼 하나로 어떨때는 입력처리를, 어떤 경우는 수정처리를 한다
			// 어떻게 나누지? 부모창에서 버튼이 눌려졌을 때, set메소드를 호출하는데
			// 이때 입력이면 세번째 파라미터에 null을 입력하고 만일 수정이라면
			// JTable에서 선택된 로우의 인덱스로 DeptVO를 추출해서 세번째 파라미터에 null 대신
			// 입력해준다(내안에 수정하고자 하는 로우의 DeptVO가 있고 그 안에는 deptno, dname, loc가 있다.)
            if (pdVO == null) {
				System.out.println("(다이얼)입력모드");
                
				if (isOk) {
					DeptVO insVO = DeptVO.builder().deptno(Integer.parseInt(getDeptno())).dname(getDname()).loc(getLoc()).build();
					System.out.println("before : " + DeptTable7.vdata.size());
					DeptTable7.vdata.add(insVO);
					System.out.println("after : " + DeptTable7.vdata.size());
					deptTable7.refreshData();
					
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "중복검사하세요.", "WARN", JOptionPane.WARNING_MESSAGE);
				}

            } else {
				System.out.println("(다이얼)수정모드");

				// 처음에는 벡터에 Generic으로 String[] 사용하였으므로 2중 for문을 사용해야 했음
				// 그런데 지금 DeptVO로 변경했으니깐 for문 하나면 됨
				for (int i=0; i<DeptTable7.vdata.size(); i++) {
					DeptVO comVO = DeptTable7.vdata.get(i);
					// 부모창(DeptTable7)에서 받아온 부서번호(set메소드 세번째 파라미터)와
					// 벡터에서 꺼낸 DeptVO의 부서번호가 같니?
					if (pdVO.getDeptno() == comVO.getDeptno()) {
						if (isOk) {
							// 사용자가 입력한 부서정보를 새로 가져와서 DeptVO에 담기
							DeptVO updVO = DeptVO.builder().deptno(Integer.parseInt(getDeptno())).dname(getDname()).loc(getLoc()).build();
							DeptTable7.vdata.set(index, updVO);
							break;
						} else {
							JOptionPane.showMessageDialog(this, "중복검사하세요.", "WARN", JOptionPane.WARNING_MESSAGE);
						}
						this.dispose();
					}
				}

				// // 베열로 했을때
                // String[] oneRow = { getDeptno(), getDname(), getLoc()};
                // DeptTable7.vdata.remove(index);
				// DeptTable7.vdata.add(index, insVO);
				// // 벡터로 했을 때
				// DeptVO insVO = DeptVO.builder().deptno(Integer.parseInt(getDeptno())).dname(getDname()).loc(getLoc()).build();
				// DeptTable7.vdata.set(index, insVO);
                deptTable7.refreshData();
                

            }
            
        } // end of SAVE

		else if (obj == jbtn_check) {
			System.out.println("(다이얼)중복체크 버튼");
			int index = Integer.parseInt(jtf_deptno.getText());
			System.out.println("index : " + index);

			if (DeptTable7.vdata.size() == 0) {
				System.out.println("부서가 비어있습니다.");
				isOk = true;
			} else {
				System.out.println("부서가 있습니다.");

				for (int i=0; i<DeptTable7.vdata.size(); i++) {
					DeptVO pdVO = DeptTable7.vdata.get(i);
					System.out.println("index : " + index + ", pdVO.dno : " + pdVO.getDeptno());
					
	
					if (index == pdVO.getDeptno()) {
						System.out.println("중복되는 부서번호가 있습니다.");
						JOptionPane.showMessageDialog(this, "중복되는 부서번호가 있습니다.", "WARN", JOptionPane.WARNING_MESSAGE);
						isOk = false;
						// break;
					} else {
						System.out.println("없음");
						isOk = true;
					}
				}
			}
		}

		else if (obj == jbtn_sample) {
			System.out.println("(다이얼)샘플 버튼");
			setDeptno("30");
			setDname("운영부");
			setLoc("세종");
		} // end of SAMPLE

		else if (obj == jbtn_close) {
            // 종료버튼
            System.out.println("(다이얼)종료 버튼");
			
			this.dispose();
        } // end of CLOSE
    }

}