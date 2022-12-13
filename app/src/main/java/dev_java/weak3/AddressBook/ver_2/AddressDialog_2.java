package dev_java.weak3.AddressBook.ver_2;

import java.lang.reflect.AnnotatedWildcardType;

import javax.swing.JDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressDialog_2  implements ActionListener{
    JDialog jdg = new JDialog();

    AddressBook_2 aBook_2 = null;

    // System.exit(0); => 애플리케이션 전체 종료
    // jf.dispose(); => 창 순차적으로 하나씩 종료

    public AddressDialog_2(){

    }
    public AddressDialog_2(AddressBook_2 aBook_2) {
        this.aBook_2 = aBook_2;
        jdg.setSize(400,300);
        //// true 값을 넣으면 디버깅 시 바로 UI창이 실행된다
        // jdg.setVisible(true);
        jdg.setVisible(false);
    }

    public void setDialog(String title, boolean isView) {
        jdg.setTitle(title);
        jdg.setVisible(isView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if (obj==aBook_2.jbtn_sel) {
            jdg.setTitle("조회");
            jdg.setVisible(true);
            System.out.println("조회 창 실행");
        } else if (obj==aBook_2.jbtn_ins) {
            jdg.setTitle("입력");
            jdg.setVisible(true);
            System.out.println("입력 창 실행");
        } else if (obj==aBook_2.jbtn_upd) {
            jdg.setTitle("수정");
            jdg.setVisible(true);
            System.out.println("수정 창 실행");
        } else if (obj==aBook_2.jbtn_info) {
            jdg.setTitle("상세보기");
            jdg.setVisible(true);
            System.out.println("상세보기 창 실행");
        }
    }
}

