package dev_java.weak3.d221215.Tables;

import java.util.Vector;

public class Vector2 {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add("사과");
        v.add("토마토");        
        v.add(1, "바나나");

        for (int i=0; i<v.size(); i++) {
            System.out.println(v.get(i));
        }
    }
}
