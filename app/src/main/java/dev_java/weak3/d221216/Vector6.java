package dev_java.weak3.d221216;

import java.util.Scanner;
import java.util.Vector;

public class Vector6 {
    String[] menue = { "부서번호", "부서명", "지역" };
    String[][] dept = { { "10", "개발부", "서울" }, { "20", "인사부", "인천" }, { "30", "총무부", "부산" } };

    Vector<String[]> vDept = new Vector<>();

    void intoVector() {
        for (int i = 0; i < dept.length; i++) {
                vDept.add(dept[i]);
        }
    }

    public static void main(String[] args) {
        Vector6 v6 = new Vector6();

        System.out.println("부서 벡터 출력\n");
        v6.intoVector();
        for (int i = 0; i < v6.vDept.size(); i++) {
            String[] oneRow = v6.vDept.get(i);
            for (int j=0; j<oneRow.length; j++) {
                System.out.print(oneRow[j] + " ");
            }
            System.out.println();
        }
    }
}
