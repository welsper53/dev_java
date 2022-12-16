package dev_java.weak3.d221216;

import java.util.Scanner;
import java.util.Vector;

public class DeptList1 {
    Vector<DeptVO> vdepts = new Vector<>();

    // 부서등록
    int deptInsert(DeptVO pdVO) {
        int result = -1;
        boolean isOk = vdepts.add(pdVO);
        result = isOk ? 1 : 0;

        return result;
    }

    // 부서수정 <- 부서명, 지역만 수정할 수 있다.
    int deptUpdate(DeptVO pdVO) {
        int result = -1;
        boolean isOk = false;

        for (int i=0; i<vdepts.size(); i++) {
            if ( pdVO.getDeptno() == vdepts.get(i).getDeptno() ) {
                isOk = vdepts.set(i, pdVO) != null;
            }
        }

        result = isOk ? 1 : 0;

        return result;
    }

    // 부서삭제
    int deptDelete(int deptno) {
        int result = -1;
        boolean isOk = false;

        for (int i=0; i<vdepts.size(); i++) {
            if ( deptno == vdepts.get(i).getDeptno() ) {
                isOk=vdepts.remove(vdepts.get(i));
            }
        }

        result = isOk ? 1 : 0;

        return result;
    }

    // 부서 전체 조회
    void getDeptList() {
        System.out.println("부서 전체 조회 출력");
        for (int i = 0; i < vdepts.size(); i++) {
            DeptVO rdVO = vdepts.get(i);
            System.out.println(rdVO.getDeptno() + ", " + rdVO.getDname() + ", " + rdVO.getLoc());
        }
        System.out.println();
    }

    void defaultDeptList() {
        DeptVO dvo = new DeptVO(10, "개발부", "서울");
        vdepts.add(dvo);
        dvo = new DeptVO(20, "인사부", "인천");
        vdepts.add(dvo);
        dvo = new DeptVO(30, "총무부", "부산");
        vdepts.add(dvo);
    }

    public static void main(String[] args) {
        DeptList1 deptList = new DeptList1();
        // 기본부서 설정
        deptList.defaultDeptList();
        // 부서 전체 조회
        deptList.getDeptList();

        // 부서 등록
        DeptVO dvo = new DeptVO(40, "자재부", "대전");
        int result = deptList.deptInsert(dvo);

        if (result == 1) {
            System.out.println("등록 되었습니다.");
            deptList.getDeptList();
        }

        // 부서 수정
        dvo = new DeptVO(30, "욜로부", "제주");
        result = deptList.deptUpdate(dvo);

        if (result == 1) {
            System.out.println("수정 되었습니다.");
            deptList.getDeptList();
        }

        // 부서 삭제
        int deptno = 20;
        System.out.println("삭제할 부서코드 : " + deptno);
        result=deptList.deptDelete(deptno);

        if (result == 1) {
            System.out.println("삭제 되었습니다.");
            deptList.getDeptList();
        }
    }
}
