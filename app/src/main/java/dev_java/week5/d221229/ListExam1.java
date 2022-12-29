package dev_java.week5.d221229;

import java.util.ArrayList;
import java.util.List;

import dev_java.oracle.DeptVO;

public class ListExam1 {

    public static void main(String[] args) {
        List<DeptVO> deptList = new ArrayList<>();
        DeptVO dVO = DeptVO.builder().deptno(10).dname("총무부").loc("서울").build();
        deptList.add(dVO);
        dVO = DeptVO.builder().deptno(20).dname("인사부").loc("부산").build();
        deptList.add(dVO);
        dVO = DeptVO.builder().deptno(30).dname("개발부").loc("제주").build();
        deptList.add(dVO);

        for (DeptVO d : deptList) {
            // System.out.println(d);
            System.out.println(d.getDeptno() + ", " + d.getDname() + ", " + d.getLoc());
        }
        System.out.println("====================");
        for (int i = 0; i < deptList.size(); i++) {
            DeptVO d = deptList.get(i);
            // System.out.println(deptList.get(i));
            System.out.println(d.getDeptno() + ", " + d.getDname() + ", " + d.getLoc());
        }
    }
}
