// 경로 src/test/java/dev_java/weak2/RepeatedTest1.java
package dev_java.weak2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTest2 {
    @DisplayName("0~9 채번")
    @RepeatedTest(10)        // 반복된 테스트를 하기 위해 사용되는 어노테이션
    void methodA() {
        int com = (int)(Math.random()*10);
        com = (int)(Math.random());
        double com2 = Math.random()*10;        
        System.out.println(com + ", " + com2);
    }

}
