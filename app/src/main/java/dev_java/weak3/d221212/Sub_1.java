package dev_java.weak3.d221212;

public class Sub_1 {
    public static void main(String[] args) {
        Main_1 m1 = new Main_1();
        for (int i = 0; i < m1.isOk.length; i++) {
            System.out.println(m1.isOk[i]); // false, false, false
        }
        System.out.println("====================");
        for (boolean isOk : m1.isOk) { // 개선된 for문
            System.out.println(isOk);
        }
        System.out.println("====================");
    }
}
