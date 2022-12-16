// 연습문제3
// 0 부터 9사이의 임의의 수를 100개를 채번하여 한 줄에 10개씩
// 출력하고 그 숫자의 빈도수를 계산하여 출력하시오
// 원본 : 0 1 2 3 4 5 6 7 8 9
// 2 5 6 8 7 8 9 0 1 1
// 5
// 3
// 3
// 7
// 9
// 2
// 0 4 5 6 6 7 8 8 9 9

// 숫자 : 0 1 2 3 4 5 6 7 8 9
// 갯수 : 10 9 18 11 7 9 15 14 7 5

package dev_java.weak3.d221215;

import java.util.Random;

public class HWork3 {
    int[] cnt = new int[10];

    int[] initArray(int datas[], int size) {
        int i;
        for (i = 0; i < datas.length; i++) {
            datas[i] = (int) (Math.random() * 10);
        }
        dataPrint(datas);
        return datas;
    }

    void dataPrint(int[] datas) {
        System.out.println("원본 : 0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + " ");
            if (i % 10 == 9) {
                System.out.println();
            }
        }
    }

    // 빈도검사 배열에 들어있는 숫자를 증가시킴
    void countNum(int[] datas) {
        int index = 0;
        for (int i=0; i<datas.length; i++) {
            index = datas[i];
            cnt[index]++;
        }
        System.out.println("\n숫자 : 0 1 2 3 4 5 6 7 8 9");
        System.out.print("갯수 : " );
        for (int i=0; i<9; i++) {
            System.out.print(cnt[i] + " ");
        }
    }
    public static void main(String[] args) {
        HWork3 hw3 = new HWork3();
        int datas[] = new int[100];
        hw3.initArray(datas, 100);
        hw3.countNum(datas);
    }

}
