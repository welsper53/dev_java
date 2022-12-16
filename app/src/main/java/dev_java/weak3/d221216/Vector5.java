package dev_java.weak3.d221216;

import java.util.Vector;

public class Vector5 {
    public static void main(String[] args) {
        String fruits[] = { "키위", "포도", "사과", "멜론", "파인애플", "바나나", "복숭아" };
        // 저 과일 중에서 본인이 좋아하는 과일만 골라서 Vector에 담아주세요.
        // insert here
        String myFruits[] = { "포도", "복숭아", "사과", "딸기", "귤" };
        Vector<String> vfruit = new Vector<>();

        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < myFruits.length; j++) {
                if (fruits[i].equals(myFruits[j])) {
                    vfruit.add(fruits[i]);
                }
            }
        }

        for (String f : vfruit) {
            System.out.println("내가 좋아하는 과일은 " + f);
        }
    }

}
