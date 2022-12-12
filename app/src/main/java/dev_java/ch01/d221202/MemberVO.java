package dev_java.ch01.d221202;
// 자료구조의 일부로 사용한다.
// 회원정보를 관리하기 위한 목적으로 설계하였다.
// => main 메소드는 필요없다.
public class MemberVO {
     // private으로 선언된 변수는 클래스 외부에서 사용 불가능하다.
     // -> 캡슐화
     private String mem_id = null;
     private String mem_pw = null;
     private String mem_name = null;
     public String test_name = null;

     
     // setter = write, save
     // setter 메소드를 활용하여 전역변수 mem_id를 초기화한다.
     public void setMem_id(String mem_id) {
          // "this"가 붙는건 전역변수이다.
          this.mem_id = mem_id;
     }
     // getter = read, listen
     public String getMem_id() {
          return mem_id;
     }

     public void setMem_pw(String mem_pw) {
          this.mem_pw = mem_pw;
     }
     public String getMem_pw() {
          return mem_pw;
     }
     public String getMem_name() {
          return this.mem_name;
     }
     public void setMem_name(String mem_name) {
          this.mem_name = mem_name;
     }


     public static void main(String[] args) {
          MemberVO memberVO = new MemberVO();
          memberVO.mem_id = "test";

          System.out.println(memberVO.mem_name);
          System.out.println(memberVO.mem_pw);
          System.out.println(memberVO.mem_id);         // null
     }
}
