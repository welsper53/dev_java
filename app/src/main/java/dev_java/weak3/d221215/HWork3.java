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
    public static void main(String[] args) {
        Random r = new Random();
        int[][] num = new int[10][10];
        int[] cnt = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        System.out.println("원본 : 0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                num[i][j] = r.nextInt(10);
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                switch (num[i][j]) {
                    case 0:
                        cnt[0] += 1;
                        break;
                    case 1:
                        cnt[1] += 1;
                        break;
                    case 2:
                        cnt[2] += 1;
                        break;
                    case 3:
                        cnt[3] += 1;
                        break;
                    case 4:
                        cnt[4] += 1;
                        break;
                    case 5:
                        cnt[5] += 1;
                        break;
                    case 6:
                        cnt[6] += 1;
                        break;
                    case 7:
                        cnt[7] += 1;
                        break;
                    case 8:
                        cnt[8] += 1;
                        break;
                    case 9:
                        cnt[9] += 1;
                        break;
                }
            }
        }
        System.out.println("\n숫자 : 0 1 2 3 4 5 6 7 8 9");
        System.out.println("갯수 : " + cnt[0] + " " + cnt[1] + " " + cnt[2] + " " + cnt[3] + " " + cnt[4] + " " + cnt[5] + " "
        + cnt[6] + " " + cnt[7] + " " + cnt[8] + " " + cnt[9]);

    }

}
