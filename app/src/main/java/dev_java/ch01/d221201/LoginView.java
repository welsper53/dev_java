package dev_java.ch01.d221201;

// java.lang 폴더에 없는 클래스는 모두 import문을 작성함
import javax.swing.JFrame;

public class LoginView {
     public static void main(String[] args) {
          JFrame jf_login = new JFrame();

          // inert here
          // 로그인창 가로,세로 길이
          int width = 500;                        
          int height = 200;

          // 로그인창 타이틀 출력
          String name = "로그인 화면 Ver1.0";
          jf_login.setTitle(name);    

          // 로그인창 크기 설정
          jf_login.setSize(width, height);        
          MethodExam m3 = new MethodExam();

          // 로그인창 활성화 | 비활성화
          jf_login.setVisible(m3.m2());       
     }

}
