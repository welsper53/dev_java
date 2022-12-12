package dev_java.ch01.d221201;

public class DeptVOMain {
     public static void main(String[] args) {
          DeptVO deptVO = new DeptVO();
          deptVO.deptno = 10;
          deptVO.dname = "개발1팀";
          System.out.println(deptVO.deptno);
          System.out.println(deptVO.dname);

          deptVO = new DeptVO();        // 변수 선언이 아니라 객체 생성
          deptVO.deptno = 30;
          System.out.println(deptVO.deptno);
          System.out.println(deptVO.dname);
          System.out.println(deptVO.loc);

          
     }
}
