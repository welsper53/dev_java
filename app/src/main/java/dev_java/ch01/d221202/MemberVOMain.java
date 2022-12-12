package dev_java.ch01.d221202;

public class MemberVOMain {
     public static void main(String[] args) {
          MemberVO memberVO = new MemberVO();
          String userID = "apple";
          System.out.println(userID);        // apple
          // MemberVO 클래스에서 mem_id는 접근제한자를 private으로 했으므로
          // 외부에서 접근이 불가능하다.
          // 예) String mem_id = memberVO.mem_id;      // 불가능
          // => setter 메소드를 제공하고 있다.
          
          memberVO.setMem_id("tomato");

          String id = memberVO.getMem_id();
          System.out.println(id);                 // tomato

          System.out.println(memberVO.getMem_id());      // tomato

          // test_name의 경우 접근제한자를 public으로 했으므로 직접 초기화가 가능하다.
          memberVO.test_name = "토마토";
          String name = memberVO.test_name;
          System.out.println(name);          // 토마토
          System.out.println(memberVO.test_name);       // 토마토

          // setter 메소드를 호출하는 것만으로 초기화된다.
          memberVO.setMem_name("이순신");
          System.out.println(memberVO.getMem_name());       // 이순신
          
          // 아래와 같이 sett 메소드를 호출하면 전역번수인 mem_pw에 123이 초기화 된다.
          memberVO.setMem_pw("123");
          // getter 메소드를 호출하면 전역변수 mem_pw에 저장된 값이 출력된다.
          // 만일 setter 메소드를 호출하지 않으면 null이 출력된다. <- 주의
          System.out.println(memberVO.getMem_pw());
     }
     
}
