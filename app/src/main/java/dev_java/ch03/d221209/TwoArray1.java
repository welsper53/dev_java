package dev_java.ch03.d221209;

public class TwoArray1 {
    void toWhile(int[][] arr) {
        int i = 0;

        // row
        while (i < arr.length) {
            // column
            int j=0;
            while (j < arr[i].length) {
                System.out.print("arr[" + i + "][" + j + "]=" + arr[i][j] + " ");
                j++;
            } // end of inner
            System.out.println();
            i++;
        } // end of outter
    }

    public static void main(String[] args) {
        int arr[][] = new int[2][3];

        System.out.println("============ for문 시작 ============");
        // 로우
        for (int i = 0; i < arr.length; i++) {
            // 컬럼
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("arr[" + i + "][" + j + "]=" + arr[i][j] + " ");
            } // end of inner
            System.out.println();
        } // end of outter

        System.out.println("\n=========== while문 시작 ============");

        TwoArray1 tA1 = new TwoArray1();
        tA1.toWhile(arr);
    }

}
