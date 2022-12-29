package dev_java.week5.d221229;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest1 {
    Map<String, Object> rMap = new HashMap<>(); // rMap.size() = 0

    public void setMap() {
        rMap.put("deptno", 10);
        rMap.put("dname", "인사부");
        rMap.put("loc", "서울");
    }

    public static void main(String[] args) {
        MapTest1 mt1 = new MapTest1();
        // System.out.println(mt1.rMap.size()); // 0
        mt1.setMap();
        System.out.println(mt1.rMap.size()); // 0->3

        // Map에서 제공하는 메소드 중에서 key값을 묶음처리하는 메소드가 있다
        // Set은 구현체클래스가 아니다
        Set<String> set = mt1.rMap.keySet();
        
        // ============ Object 활용 ============
        // Set인터페이스가 제공하는 메소드 중에서 toArray()지원함
        Object[] obj = set.toArray();   // deptno, dname, loc
        for (int i = 0; i < obj.length; i++) { // obj.length는 배열의 원소 수 - 3개 (dept, dname, loc)
            String key = (String) obj[i];   // 배열에서 꺼낸 값은 key값이다 -  deptno, dname, loc
            System.out.println("key : " + key); // 3번 출력
        }

        // ============ Iterator 활용 ============
        Iterator<String> iter = set.iterator();

        while (iter.hasNext()) { // 자료구조 안에 값이 있는지 체크해서 잇으면 true를 반환, 없으면 false
        String key = iter.next();
        // String value = (String)mt1.rMap.get(key);
        Object value = mt1.rMap.get(key);
        System.out.println(key + " : " + value);
        }

    }
}
