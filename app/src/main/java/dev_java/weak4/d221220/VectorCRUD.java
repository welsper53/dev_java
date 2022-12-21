package dev_java.weak4.d221220;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
// List - 순서, 느리다, 정렬, 추가하면 맨 뒤에 채운다.
// index가 다르면 중복값 저장 가능
import javax.swing.JOptionPane;

public class VectorCRUD {
    static Vector<String[]> vdept = new Vector<>();
    static Vector<DeptVO> vdept2 = new Vector<>();

    public void getDeptList() {
        for (int i = 0; i < vdept.size(); i++) {
            String[] oneRow = vdept.get(i);
            for (int j = 0; j < oneRow.length; j++) {
                System.out.print(oneRow[j] + " ");
            }
            System.out.println();
        }
    }

    // 벡터에 부서정보 추가하기 - 없는 것을 새로 추가
    // pass by value로 호출하는 경우 주소번지를 받아옴 - 원본을 받는것 main.ival, sub.ival
    public int deptInsert(String[] oneRow) {
        // 지역변수 - 메소드 영역안에서
        System.out.println("\n부서정보 입력 호출");
        // 1이면 성공, 0이면 실패
        int result = 0;
        boolean isOk = vdept.add(oneRow);
        if (isOk) {
            result = 1;
        }

        return result;
    } // end of deptInsert()

    /*
     * *************************************************************
     * 벡터에 부서정보 수정하기 - 있는 것을 변경
     * 
     * @param deptno 수정하고자 하는 부서번호
     * @param user_dname 수정하고자 하는 부서명
     * @param user_loc 수정하고자 하는 지역
     * @return 1이면 성공, 0이면 수정 실패
     ************************************************************* */
    public int deptUpdate(int deptno, String user_dname, String user_loc) {
        System.out.println("\n부서정보 수정 호출 : " + deptno + ", " + user_dname + ", " + user_loc);
        String[] oneRow = null;
        String[] comRow = null;
        for (int i = 0; i < vdept.size(); i++) {
            comRow = vdept.get(i);
            if (deptno == Integer.parseInt(comRow[0])) {
                // 얕은 복사 - 하나를 바꾸면 다같이 바뀐다
                oneRow = comRow;
                // <-> 깊은 복사 - 각자 바뀐다
                break;
            }
        }
        // 1이면 성공, 0이면 실패
        int result = 0;
        here:
        for (int i = 0; i < vdept.size(); i++) {
            String[] row = vdept.get(i);
            for (int j = 0; j < row.length; j++) {
                int deptno2 = 0;
                deptno2 = Integer.parseInt(row[0]);
                if (deptno == deptno2) {
                    String[] updRow = { oneRow[0], user_dname, user_loc };
                    // vdept.set(i, updRow);
                    // 수정이라 말하고 입력으로 처리함 - 한 셀씩 수정
                    vdept.remove(i);
                    // Vector를 사용하면 배열의 모든 단점을 보완함 - 고정, 타입단점
                    // 기본 : Vector<Object>
                    vdept.add(i, updRow);
                    result = 1;
                    // break문만 사용 시 이중 for문에서 내부 for문만을 탈출하게 되는데
                    // 여기서 외부 for문을 빠져나가야하므로 라벨문을 붙여서 처리한다
                    break here;
                } else {
                    System.out.println("선택한 부서번호와 벡터에서 가져온 부서번호가 다르다");
                }
            } // end of String[] <-inner for
        } // end of Vector <- 바깥쪽 for문에 라벨문을 사용할 것
        getDeptList();
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
                    break;
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
        VectorCRUD vCrud = new VectorCRUD();
        Scanner s = new Scanner(System.in);

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
        System.out.print("수정할 부서번호,부서명, 지역을 입력(|로 구분) : ");
        String user = s.nextLine(); // 10|인사부|포항
        int user_deptno = 0;
        String user_dname = null;
        String user_loc = null;
        StringTokenizer st = new StringTokenizer(user, "|");
        user_deptno = Integer.parseInt(st.nextToken());
        user_dname = st.nextToken();
        user_loc = st.nextToken();
        int result2 = vCrud.deptUpdate(user_deptno, user_dname, user_loc);

        // 삭제 테스트
        System.out.println("\n====삭제 테스트====");
        System.out.print("삭제할 부서번호 : ");
        int user2 = s.nextInt();
        // vCrud.deptDelete(user);
        int result3 = vCrud.deptDelete(user2);
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
