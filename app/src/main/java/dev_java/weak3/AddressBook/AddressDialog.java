package dev_java.weak3.AddressBook;

import java.lang.reflect.AnnotatedWildcardType;

import javax.swing.JDialog;

public class AddressDialog {
    JDialog jdg = new JDialog();
    // System.exit(0); => 애플리케이션 전체 종료
    // jf.dispose(); => 창 순차적으로 하나씩 종료
    public AddressDialog() {
        jdg.setTitle("입력|수정|상세보기");
        jdg.setSize(400,300);
        //// true 값을 넣으면 디버깅 시 바로 UI창이 실행된다
        // jdg.setVisible(true);
        jdg.setVisible(false);
    }

    public static void main(String[] args) {
        new AddressDialog();
    }
}
