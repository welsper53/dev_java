package dev_java.weak4.d221220;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
// List - 순서, 느리다, 정렬, 추가하면 맨 뒤에 채운다.
// index가 다르면 중복값 저장 가능
import javax.swing.JOptionPane;

public class VectorCRUD2 {
    static Vector<String[]> vdept = new Vector<>();
    static Vector<DeptVO> vdept2 = new Vector<>();

    public void getDeptList() {
        DeptVO oneRow;
        for (int i = 0; i < vdept2.size(); i++) {
            oneRow = new DeptVO(vdept2.get(i).getDeptno()
            , vdept2.get(i).getDname()
            , vdept2.get(i).getLoc());

            System.out.println(oneRow.getDeptno() 
            + " " + oneRow.getDname() 
            + " " + oneRow.getLoc());
        }
    }

    // 벡터에 부서정보 추가하기 - 없는 것을 새로 추가
    public int deptInsert(String[] oneRow) {
        System.out.println("\n부서정보 입력 호출");
        int result = 0;
        
        // DeptVO imsi = new DeptVO(setDeptno(Integer.parseInt(oneRow[0]))
        // , setDname(oneRow[1])
        // , setLoc(oneRow[2]));
        DeptVO imsi;
        // imsi.setDeptno(Integer.parseInt(oneRow[0]));
        // imsi.setDname(oneRow[1]);
        // imsi.setLoc(oneRow[2]);

        return result;
    } // end of deptInsert()

    // 벡터에 부서정보 수정하기 - 있는 것을 변경
    public int deptUpdate(String[] oneRow) {
        System.out.println("\n부서정보 수정 호출");
        int result = 0;
        for (int i = 0; i < vdept.size(); i++) {
            String[] imsi = vdept.get(i);
            if (Integer.parseInt(oneRow[0]) == Integer.parseInt(imsi[0])) {
                vdept.remove(i);
                vdept.add(i, oneRow);
                result = 1;
            }
        }

        return result;
    } // end of deptUpdate()

    // 벡터에 부서정보 삭제하기 - 있는 것을 삭제
    // 벡터에 있는 부서 정보 중에서 어떤 로우를 삭제할 건지 부서번호를 받아와야 함
    // 이것은 사용자로 부터 받아와야 하는 값임 - 그런데 int형
    // 그런데 String[]에서 부서번호는 String타입
    // 그러니까 형전환 필요함 - 그런데 null이 오면 NumberFormatExceptio발생할 가능성 있음
    // 방어코드 작성 필요함 - null에 대한 이슈는 현재 프로그래밍에 있어 심각한 장애로 인식
    // --> 중요한 문제임
    public int deptDelete(int deptno) {
        System.out.println("\n부서정보 삭제 호출");
        // 1이면 성공, 0이면 실패
        int result = 0;
        for (int i = 0; i < vdept.size(); i++) {
            String[] oneRow = vdept.get(i);
            // if (Integer.parseInt(oneRow[0]) == Integer.parseInt(imsi[0])) {
            // vdept.remove(i);
            // result = 1;
            // }
            int deptno2 = 0;

            // ★★☆★★예외 발생에 대한 우려 방어코드 작성★★☆★★
            // null 체크를 하였다
            // -> 이것까지도 프레임워크에서 떠안으려 하고 있다. 이미 떠안았다
            if (oneRow[0] != null) {
                deptno2 = Integer.parseInt(oneRow[0]);
            }

            // 사용자가 선택한 부서번호와 벡터에 있는 부서번호를 비교하여 같은 것 찾기
            if (deptno == deptno2) {
                // 삭제할 벡터의 로우값이 필요함 - 이것은 벡터의 size를 통해 찾아냄
                // 여기서는 변수 i가 인덱스 값에 해당함
                // remove메소드 파라미터가 int인 경우에대해 서만
                // 삭제된 벡터의 제네릭 반환해준다.
                // 그것을 받아 처리 여부 확인 가능
                String[] deleteRow = vdept.remove(i);
                System.out.println("삭제된 배열은 " + Arrays.toString(deleteRow));
                // 삭제 한 객체가 존재하니? 네:삭제되었음 아니:삭제 안됨
                if (deleteRow != null) {
                    JOptionPane.showMessageDialog(null, "삭제 처리 되었습니다.");
                    // 삭제 처리가 성공한 경우이므로 반환값 1 리턴해준다. 끝
                    result = 1;
                }
            }
        }
        return result;
    } // end of deptDelete()

    // 벡터에 부서정보 상세보기 - 있는 것을 하나 꺼내보기
    public String[] deptDetail(int index) { // or int deptno (파라미터)
        String[] oneRow = new String[3];
        for (int i = 0; i < vdept.size(); i++) {
            oneRow = vdept.get(i);
            if (Integer.toString(index).equals(oneRow[0])) {
                break;
            }
        }
        return oneRow;
    } // end of deptDetail()

    public static void main(String[] args) {
        VectorCRUD2 vCrud = new VectorCRUD2();

        // 입력 테스트
        System.out.println("====입력 테스트====");
        // 제네릭 타입으로 사용할 거야
        String[] oneRow = { "10", "개발부", "서울" };
        int result1 = vCrud.deptInsert(oneRow);
        String[] oneRow2 = { "20", "영업부", "부산" };
        result1 = vCrud.deptInsert(oneRow2);

        if (result1 == 1) {
            JOptionPane.showMessageDialog(null, "등록되었습니다.");
            vCrud.getDeptList();
            // // 조건문 안에 return문 해당 메소드 블록을 빠져나온다
            // return;
        }

        // 수정 테스트
        System.out.println("\n====수정 테스트====");
        String[] oneRow3 = { "10", "총무부", "인천" };
        int result2 = vCrud.deptUpdate(oneRow3);
        vCrud.getDeptList();

        // 삭제 테스트
        System.out.println("\n====삭제 테스트====");
        Scanner s = new Scanner(System.in);
        System.out.print("삭제할 부서번호 : ");
        int user = s.nextInt();
        // vCrud.deptDelete(user);
        int result3 = vCrud.deptDelete(user);
        if (result3 == 1) {
            JOptionPane.showMessageDialog(null, "삭제되었습니다.");
            vCrud.getDeptList();
            // return;
        }
        s.close();

        // 상세보기 테스트
        System.out.println("\n====상세보기 테스트====");
        int deptno = 10;
        String[] result4 = vCrud.deptDetail(deptno);

        for (int i = 0; i < result4.length; i++) {
            System.out.print(result4[i] + " ");
        }
        // vCrud.getDeptList();

    } // end of main
}
