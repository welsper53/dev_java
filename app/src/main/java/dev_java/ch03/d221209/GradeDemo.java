package dev_java.ch03.d221209;
// 연습문제

// 다음은 자바중간고사 채점 결과표이다.
// 학생별 총점, 평균, 석차를 구하는 프로그램을 작성하시오.

public class GradeDemo {
    String[] subject = { "JAVA", "ORACLE", "SPRING" };
    int[] subSum = {0, 0, 0};

    String[][] data = {
            { "이순신", "80", "75", "70" }, { "강감찬", "90", "85", "95" }, { "김춘추", "65", "60", "60" }
    };
    int sum[] = new int[3];
    double avgs[] = new double[3];
    int rank[] = new int[3];

    // [학생점수의 총점, 평균]
    void student() {
        for (int i = 0; i < data.length; i++) {
            // 과목 점수 column
            for (int j = 1; j < data[i].length; j++) {
                // 과목 총점
                sum[i] += Integer.parseInt(data[i][j]);
            }
            // 과목 평균
            avgs[i] = (sum[i]) / data[i].length;
        }
    }

    // [학생석차 구하기]
    void stRank() {
        for (int i = 0; i < rank.length; i++) {
            
            // int result[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
            // 순위 배열을 for 돌때마다 1등 초기화
            rank[i] = 1;

            // 배열 i 인덱스의 점수와 나머지 점수 비교
            for (int j = 0; j < rank.length; j++) {
                // i 인덱스의 값보다 크다면, 순위 증가
                if (avgs[i] < avgs[j]) {
                    rank[i] += 1;
                }
            }
        }
    }

    void printResult() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(
                    data[i][0] + " 학생 총점 : " + sum[i] + ", 평균 : " + avgs[i] + ", 석차 : " + rank[i]);
        }
    }

    void subjectResult() {
        for (int i=0; i<subSum.length; i++) {
            for (int j=0; j<data.length; j++)
            subSum[i] += Integer.parseInt(data[j][i+1]);
        }
    }
    void printSubResult() {
        for (int i=0; i<subject.length; i++) {
            System.out.println(subject[i] + " 과목의 총합 : " + subSum[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GradeDemo gDemo = new GradeDemo();

        gDemo.subjectResult();
        gDemo.printSubResult();

        gDemo.student();
        gDemo.stRank();
        gDemo.printResult();

    }

}
