// 연습문제2
// -10에서 10사이의 정수 10개를 랜덤하게 채번하여 
// 음수와 양수의 합계를 구하는 프로그램을 작성하시오.
// 출력)
//    배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
//    음수합 : -24
//    양수합 : 17

package dev_java.weak3.d221215;

public class HWork2 {
    int[] users = null;
    int mhap, phap;

    // 메소드 선언하기
    void setArray() {
        // Random r = new Random();
        // for (int j = 0; j < 10; j++) {
        // int i = r.nextInt(20) - 9;
        // System.out.print(i + " ");
        // }
        users = new int[10];
        System.out.print("배열 : ");
        for (int i = 0; i < users.length; i++) {
            // Math.random() : 실수형 0.0~1.0
            users[i] = (int) (Math.random() * 21) % 21 - 10;
            System.out.print(users[i] + " ");
        }
    }

    void setArray(int size) {
        users = new int[size];
        System.out.print("배열 : ");
        for (int i = 0; i < users.length; i++) {
            users[i] = (int) (Math.random() * 21) % 21 - 10;
            System.out.print(users[i] + " ");
        }
    }

    void total() {
        mhap=0;
        phap=0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] < 0) {
                mhap += users[i];
            } else if (users[i] > 0) {
                phap += users[i];
            } else {

            }
        }
        System.out.println("\n음수합 : " + mhap);
        System.out.println("양수합 : " + phap);

    }

    // 난수 수집 체크
    void nansuPrint() {
        // insert here

    }

    public static void main(String[] args) {
        HWork2 hw2 = new HWork2();

        hw2.setArray();
        hw2.total();

        hw2.setArray(5);
        hw2.total();
    }
}
