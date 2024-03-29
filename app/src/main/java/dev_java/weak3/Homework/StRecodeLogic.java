package dev_java.weak3.Homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Vector;

import javax.swing.JScrollBar;

public class StRecodeLogic implements ActionListener {
    StRecode stRecode = null;

    public StRecodeLogic(StRecode stRecode) {
        this.stRecode = stRecode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == stRecode.jbtn_make) {
            System.out.println("jbtn_make 입력");
            int input = Integer.parseInt(stRecode.jtf_insert.getText());
            String members[][] = new String[input][7];

            // 이미 테이블에 조회된 정보가 있는 경우 모두 삭제한다
            while (stRecode.dtm_recode.getRowCount() > 0) {
                stRecode.dtm_recode.removeRow(0);
            }
            for (int i = 0; i < members.length; i++) {
                Vector<String> oneRow = new Vector<>();
                for (int j = 0; j < 7; j++) {
                    oneRow.add(members[i][j]);
                }
                stRecode.dtm_recode.addRow(oneRow);
            }
            // 익명 클래스 문법사용
            // -> 자바 람다식, 자바스크립트 Arrow Function 문법과 유사
            // 코틀린 문법
            stRecode.jsp_recode.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
                public void adjustmentValueChanged(AdjustmentEvent e) {
                    JScrollBar jsb = (JScrollBar) e.getSource();
                    jsb.setValue(jsb.getMaximum());
                }
            });

        } else if (obj == stRecode.jbtn_oper) {
            // 표의 성적값 연산
            System.out.println("jbtn_oper 입력");
            int[] sum = new int[stRecode.dtm_recode.getRowCount()];
            double[] avg = new double[stRecode.dtm_recode.getRowCount()];
            int[] rank = new int[stRecode.dtm_recode.getRowCount()];

            System.out.println("======= " + stRecode.dtm_recode.getRowCount());

            for (int i = 0; i < stRecode.dtm_recode.getRowCount(); i++) {
                rank[i] = 1;
                for (int j = 1; j <= 3; j++) {
                    sum[i] += Integer.parseInt(stRecode.datas[i][j]);
                    avg[i] = sum[i] / 3;
                }
            }

            for (int i = 0; i < stRecode.dtm_recode.getRowCount(); i++) {
                rank[i] = 1;
                for (int n = 0; n < stRecode.dtm_recode.getRowCount(); n++) {
                    if (avg[i] < avg[n]) {
                        rank[i] += 1;
                    }
                }
                stRecode.datas[i][4] = Integer.toString(sum[i]);
                stRecode.datas[i][5] = Double.toString(avg[i]);
                stRecode.datas[i][6] = Integer.toString(rank[i]);
            }

            // 새로 호출
            while (stRecode.dtm_recode.getRowCount() > 0) {
                stRecode.dtm_recode.removeRow(0);
            }
            for (int i = 0; i < stRecode.datas.length; i++) {
                Vector<String> oneRow = new Vector<>();
                for (int j = 0; j < stRecode.datas[i].length; j++) {
                    oneRow.add(stRecode.datas[i][j]);
                }
                stRecode.dtm_recode.addRow(oneRow);
            }

        } else if (obj == stRecode.jbtn_sam) { // 3명 샘플 만들기
            System.out.println("jbtn_sam 입력");
            String members[][] = { { "홍길동", "80", "75", "85" }, { "이성계", "90", "85", "80" },
                    { "강감찬", "70", "75", "70" } };
            stRecode.datas = new String[3][7];

            // 이미 테이블에 조회된 정보가 있는 경우 모두 삭제한다
            while (stRecode.dtm_recode.getRowCount() > 0) {
                stRecode.dtm_recode.removeRow(0);
            }
            for (int i = 0; i < members.length; i++) {
                Vector<String> oneRow = new Vector<>();
                for (int j = 0; j < members[i].length; j++) {
                    oneRow.add(members[i][j]);
                    stRecode.datas[i][j] = members[i][j];
                }
                stRecode.dtm_recode.addRow(oneRow);
            }
            // 스크롤바
            stRecode.jsp_recode.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
                public void adjustmentValueChanged(AdjustmentEvent e) {
                    JScrollBar jsb = (JScrollBar) e.getSource();
                    jsb.setValue(jsb.getMaximum());
                }
            });
        } else if (obj == stRecode.jbtn_del) {
            System.out.println("jbtn_del 입력");
            // 이미 테이블에 조회된 정보가 있는 경우 모두 삭제한다
            while (stRecode.dtm_recode.getRowCount() > 0) {
                stRecode.dtm_recode.removeRow(0);
            }
        } else if (obj == stRecode.jbtn_exit) {
            System.out.println("jbtn_exit 입력");
            System.exit(0);
        }

    }
}
