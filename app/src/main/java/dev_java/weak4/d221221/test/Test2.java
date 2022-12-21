package dev_java.weak4.d221221.test;

public class Test2 {
    public static void main(String[] args) {
        for(int i=2; i<=8; i+=2) {
            System.out.println(2 + "*" +i + "=" + (2*i));
        }

        // // String[] sArr = {"빨강", "노랑", "파랑"};
        // String[] sArr = {"사과", "딸기", "오렌지"};
        
        // // 1) 일반 for문
        // for (int i=0; i<sArr.length; i++) {
        //     System.out.println(sArr[i]);
        // }

        // // 2) 향상된 for문
        // for (String s : sArr) {
        //     System.out.println(s);
        // }

    }
}
