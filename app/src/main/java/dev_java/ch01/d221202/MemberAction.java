package dev_java.ch01.d221202;


public class MemberAction {
     private String mem_id = null;
     private String mem_pw = null;
     private String mem_name = null;

     public int memberInsert(String mem_id, String mem_pw, String mem_name) {
          System.out.println("memberInsert 호출 - 파라미터 3개");
          System.out.println(mem_id + ", " + mem_pw + ", " + mem_name);
          int result = -1;
     
          // 회원가입 여부
          if (mem_id != null && mem_pw != null && mem_name != null) {
               result = 1;
          } else {
               result = 0;
          }

          return result;
     }
     
     public int memberInsert(MemberVO memberVO) {
          System.out.println("memberInsert 호출 - 파라미터 3개");
          System.out.println(memberVO.getMem_id() + ", " + 
                              memberVO.getMem_pw() + ", " + 
                              memberVO.getMem_name());
          int result = 0;

          // 회원가입 여부
          if (memberVO != null) {
               result = 1;
          } 
               
          return result;
     }
     
     public static void memResult (int i) {
          if (i == 1) {
               System.out.println("회원 가입 성공하였습니다.");
          } else {
               System.out.println("회원 가입 실패하였습니다.");
          }
     }


     public static void main(String[] args) {
          MemberAction memA = new MemberAction();
          memA.mem_id = "lee";
          memA.mem_pw = "123";
          memA.mem_name = "이순신";

          int result = memA.memberInsert(memA.mem_id, memA.mem_pw, memA.mem_name);

          memResult(result);

          // class MemberVO 사용
          MemberVO memVO = new MemberVO();
          memVO.setMem_id("hong");
          memVO.setMem_pw("qwe");
          memVO.setMem_name("홍길동");

          result = memA.memberInsert(memVO);

          memResult(result);
     }
     
}
