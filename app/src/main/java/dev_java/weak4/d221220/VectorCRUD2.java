package dev_java.weak4.d221220;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
// List - 순서, 느리다, 정렬, 추가하면 맨 뒤에 채운다.
// index가 다르면 중복값 저장 가능
import javax.swing.JOptionPane;

public class VectorCRUD2 {
    static Vector<DeptVO> vdept2 = new Vector<>();

    public void getDeptList() {
        for (int i = 0; i < vdept2.size(); i++) {
            DeptVO dVO = vdept2.get(i);
            System.out.println(dVO.getDeptno() + " " + dVO.getDname() + " " + dVO.getLoc());
        }
    }

    // 벡터에 부서정보 추가하기 - 없는 것을 새로 추가
    public int deptInsert(DeptVO pdVO) {
        System.out.println("\n부서정보 입력 호출");
        int result = 0;

        boolean isOk = vdept2.add(pdVO);

        if (isOk) {
            result = 1;
        }

        return result;
    } // end of deptInsert()

    /* *************************************************************
     * 벡터에 부서정보 수정하기 - 있는 것을 변경
     * 
     * @param deptno 수정하고자 하는 부서번호
     * @param user_dname 수정하고자 하는 부서명
     * @param user_loc 수정하고자 하는 지역
     * @return 1이면 성공, 0이면 수정 실패
     ************************************************************* */
    public int deptUpdate(int index, String dname, String loc) {
        int result = 0;
        System.out.println("\n부서정보 수정 호출");

        for (int i = 0; i < vdept2.size(); i++) {
            DeptVO dVo = vdept2.get(i);

            if (index == dVo.getDeptno()) {
                dVo.setDeptno(index);
                dVo.setDname(dname);
                dVo.setLoc(loc);
                result = 1;
            }
        }
        if (result == 0) {
            System.out.println("저장되어 있지않은 부서번호입니다.");
        }

        return result;
    } // end of deptUpdate()

    // 벡터에 부서정보 삭제하기 - 있는 것을 삭제
    // --> 중요한 문제임
    public int deptDelete(int deptno) {
        System.out.println("\n부서정보 삭제 호출");
        // 1이면 성공, 0이면 실패
        int result = 0;
        for (int i = 0; i < vdept2.size(); i++) {
            DeptVO dVo = vdept2.get(i);

            // ★★☆★★예외 발생에 대한 우려 방어코드 작성★★☆★★
            // null 체크를 하였다
            // -> 이것까지도 프레임워크에서 떠안으려 하고 있다. 이미 떠안았다
            // if (dVo.getDeptno() != null) {
            // deptno2 = Integer.parseInt(oneRow[0]);
            // }

            // 사용자가 선택한 부서번호와 벡터에 있는 부서번호를 비교하여 같은 것 찾기
            if (deptno == dVo.getDeptno()) {
                System.out.println("삭제된 배열은 [" + dVo.getDeptno() + " " + dVo.getDname() + " " + dVo.getLoc() + "]");
                System.out.println();

                vdept2.remove(dVo);
                // 삭제 처리가 성공한 경우이므로 반환값 1 리턴해준다. 끝
                result = 1;
            }
        } // end of for
        return result;
    } // end of deptDelete()

    // 벡터에 부서정보 상세보기 - 있는 것을 하나 꺼내보기
    public DeptVO deptDetail(int index) { // or int deptno (파라미터)
        DeptVO dVo = null;
        for (int i = 0; i < vdept2.size(); i++) {
            dVo = vdept2.get(i);
            if (Integer.toString(index).equals(dVo.getDeptno())) {
                break;
            }
        }
        return dVo;
    } // end of deptDetail()

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        VectorCRUD2 vCrud2 = new VectorCRUD2();

        // 입력 테스트
        System.out.println("====입력 테스트====");
        // 제네릭 타입으로 사용할 거야
        DeptVO dvo1 = DeptVO.builder().deptno(10).dname("개발부").loc("인천").build();
        int result1 = vCrud2.deptInsert(dvo1);
        // 기존에 참조하는 객체와 연결을 끊는다
        dvo1 = null;
        dvo1 = DeptVO.builder().deptno(20).dname("영업부").loc("부산").build();
        result1 = vCrud2.deptInsert(dvo1);

        if (result1 == 1) {
            JOptionPane.showMessageDialog(null, "등록되었습니다.");
            vCrud2.getDeptList();
            // // 조건문 안에 return문 해당 메소드 블록을 빠져나온다
            // return;
        }

        // 수정 테스트
        System.out.println("\n====수정 테스트====");
        System.out.print("수정할 부서번호,부서명,지역 (공백으로 구분) : ");
        int user = Integer.parseInt(s.next());
        String dname = s.next();
        String loc = s.next();

        int result2 = vCrud2.deptUpdate(user, dname, loc);
        if (result2 == 1) {
            JOptionPane.showMessageDialog(null, "수정되었습니다.");
            vCrud2.getDeptList();
            // return;
        }

        // 삭제 테스트
        System.out.println("\n====삭제 테스트====");
        System.out.print("삭제할 부서번호 : ");
        user = s.nextInt();

        int result3 = vCrud2.deptDelete(user);
        if (result3 == 1) {
            JOptionPane.showMessageDialog(null, "삭제되었습니다.");
            vCrud2.getDeptList();
            // return;
        }

        // // 상세보기 테스트
        // System.out.println("\n====상세보기 테스트====");
        // System.out.print("상세보기 부서번호 : ");
        // user = s.nextInt();
        // DeptVO result4 = vCrud2.deptDetail(user);

        // System.out.println(result4.toString());

        // s.close();
    } // end of main
}
