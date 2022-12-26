package dev_java.week4.d221220;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class List2 {
    public static void main(String[] args) {
        // 자료구조를 지원하는 클래스 들은 오브젝트의 존재유무 체크
        // 포함 여부
        // 비어있는지 혹은 채워져 있는지 확인할 수 있는 api를 제공하고 있다
        List<String> fruitList = new Vector<>(); // 멀티스레드 안전 - 속도 느림 - 안전
        fruitList.add("사과");
        fruitList.add("토마토");
        boolean isExist = fruitList.contains("바나나");
        System.out.println(isExist);
        isExist = fruitList.contains("토마토");
        System.out.println(isExist);
        boolean isEmpty = fruitList.isEmpty();
        System.out.println(isEmpty);
        // Vector나 ArrayList는 오브젝트 추가, 꺼내는 기능 제공
        // Iterator는 그 안에 오브젝트 존재유무
        Iterator<String> iter = fruitList.iterator();
        while(iter.hasNext()) {
            String fname = iter.next();
            System.out.println(fname);
        }
        Iterator<String> iter2 = fruitList.iterator();
        while(iter2.hasNext()) {
            // 다이아몬드연산자에 의미임 - 타입을 명시적으로 작성함
            String fname = iter2.next();
            System.out.println(fname);
        }
        // // 아래와 같이 사용할 수 없다.
        // // 왜냐하면 Vector의 제네릭 타입이 String이기 때문
        // Iterator<Object> iter3 = fruitList.iterator();
        Iterator<String> iter4 = fruitList.iterator();

    }
    
}
