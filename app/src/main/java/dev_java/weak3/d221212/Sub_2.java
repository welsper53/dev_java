package dev_java.weak3.d221212;

public class Sub_2 {
    public static void main(String[] args) {
        Main_2 m2 = new Main_2();
        for (int i = 0; i < m2.isOk.length; i++) {
            System.out.println(m2.isOk[i]); // false, false, false
        }
        System.out.println("====================");
        for (boolean isOk : m2.isOk) { // 개선된 for문
            System.out.println(isOk);
        }
    }
}
