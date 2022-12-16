package dev_java.weak3.d221216;

import java.util.Vector;

public class Vector4 {
    public static void main(String[] args) {
        String fruits[] = { "키위", "포도", "사과", "멜론", "파인애플", "바나나", "복숭아" };
        Vector<String> vfruit = new Vector<>();
        for (int i = 0; i < fruits.length; i++) {
            vfruit.add(i, fruits[i]);
        }
        // 인덱스 1에 "토마토" 추가
        vfruit.add(1, "토마토");
        System.out.println(vfruit.size());
        for (int i = 0; i < vfruit.size(); i++) {
            System.out.println(vfruit.get(i));
        }
        // "포도" 만 삭제
        System.out.println("=============");
        for (int i = 0; i < vfruit.size(); i++) {
            if (vfruit.get(i) == "포도") {
                vfruit.remove(i);
            }
            if ("포도".equals(vfruit.get(i))) {
                vfruit.remove(i);
            }
            if (vfruit.contains("포도")) {
                vfruit.remove("포도");
            }
            System.out.println(vfruit.get(i));
        }

    }

}
