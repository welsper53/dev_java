package dev_java.weak3.d221216;

import java.util.Scanner;
import java.util.Vector;

public class Vector61 {
    Vector<String[]> vDepts = new Vector<>();
    String[] menue = { "부서번호", "부서명", "지역", "전화번호" };
    String[][] depts = { { "10", "개발부", "서울", "02-555-7788" }, { "20", "인사부", "인천", "032-555-7788" },
            { "30", "총무부", "부산", "051-555-7788" } };

    // 벡터(vDepts)에 배열(depts) 추가
    void initVector() {
        for (int i = 0; i < depts.length; i++) {
            // 벡터에 담기는 것은 1차배열이다
            // - 컬럼의 수는 바뀔 수 있다->4
            vDepts.add(depts[i]);
        }
    }

    // 벡터(vDepts) 출력
    void initVectorPrint() {
        for (int i = 0; i < vDepts.size(); i++) {
            String[] oneRow = vDepts.get(i);
            // // oneRow의 주소 출력
            // System.out.println(oneRow.toString());

            for (int j = 0; j < oneRow.length; j++) {
                System.out.print(oneRow[j] + " ");
            }
            System.out.println();
        }
    }

    // 벡터(vDepts)에 입력한 부서코드 줄 삭제
    void initVectorDell(String num) {
        for (int i = 0; i < vDepts.size(); i++) {
            String[] oneRow = vDepts.get(i);

            if (num.equals(oneRow[0])) {
                vDepts.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector61 v61 = new Vector61();
        // initVector 메소드를 경유하지 않았으므로 size는 0이다.
        System.out.println(v61.vDepts.size()); // 0

        // 벡터에 배열 추가
        v61.initVector();
        // vDepts.get(0) -> { "10", "개발부", "서울", "02-555-7788" }
        // vDepts.get(1) -> { "20", "인사부", "인천", "032-555-7788" }
        // vDepts.get(2) -> { "30", "총무부", "부산", "051-555-7788" }
        System.out.println(v61.vDepts.size()); // 3

        System.out.println("\n부서 벡터 출력");
        v61.initVectorPrint();

        // 벡터(vDepts)에 입력한 부서코드 줄 삭제
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 부서코드 : ");
        String num = sc.nextLine();

        v61.initVectorDell(num);

        System.out.println("\n부서 벡터 출력");
        v61.initVectorPrint();

        sc.close();
    }
}
