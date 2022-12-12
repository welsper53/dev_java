package dev_java.ch03.d221209;

public class TwoArray2 {
    void arryTest(String arr[][]) {
        // String sum[][] = new String[3][];
        int sum = 0;
        double avg = 0;
        // 학생 row
        for (int i = 0; i < arr.length; i++) {
            // sum[i][0] = arr[i][0];
            // 과목 점수 column
            for (int j = 1; j < arr[i].length; j++) {
                // 과목 총점
                sum += Integer.parseInt(arr[i][j]);
            }
            avg = sum / arr[i].length;
            System.out.println(arr[i][0] + " 학생 총점 : " + sum + ", 평균 : " + avg);
        }
    }


    public static void main(String[] args) {
        // int arr[][] = new int[3][3];
        // arr[0] = new int[] { 1, 2, 3 };
        // arr[1] = new int[] { 4, 5, 6 };
        // arr[2] = new int[] { 7, 8, 9 };

        // // insert here - 5
        // System.out.println(arr[1][1]);
        // System.out.println(arr[2][2]);

        // 연습문제
        // 다음은 자바중간고사 채점 결과표이다.
        // 학생별 총점, 평균, 석차를 구하는 프로그램을 작성하시오.

        String[][] data = {
            {"이순신", "80", "75", "70"}
                , {"강감찬", "90", "85", "95"}
                , {"김춘추", "65", "60", "60"}
        };



    }



}
