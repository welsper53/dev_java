package dev_java.week5.d221229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest3 {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> pMap = new HashMap<>();
        // 회원아이디, 회원이름, 회원비번, 성별
        // mem_id, mem_name, mem_pw, mem_gender
        // tomato, 토마토, 123, 남자
        // banana, 바나나, 123, 여자
        // kiwi, 키위, 123, 남자

        pMap.put("mem_id", "tomato");
        pMap.put("mem_name", "토마토");
        pMap.put("mem_pw", "123");
        pMap.put("mem_gender", "남자");
        list.add(pMap);

        // insert here
        // List<Map<>> - 밖에 있는 List는 대괄호로 묶음
        // 제네릭은 {} 좌중괄호 우중괄호로 묶음
        // list이용

        // System.out.println(list); // [{mem_gender=남자, mem_pw=123, mem_name=토마토,
        // mem_id=tomato}]
        // System.out.println(list.get(0)); // {mem_gender=남자, mem_pw=123, mem_name=토마토,
        // System.out.println(pMap); // @abcd1234 -> {mem_gender=남자, mem_pw=123,
        // mem_name=토마토, mem_id=tomato}
        // System.out.println(pMap.toString()); // @abcd1234 -> {mem_gender=남자,
        // mem_pw=123, mem_name=토마토, mem_id=tomato}
        // System.out.println(list.get(0).get("mem_name")); // 토마토

        pMap = new HashMap<>(); // 새로운 객체가 생성됨 <- 타입은 동일
        pMap.put("mem_id", "banana");
        pMap.put("mem_name", "바나나");
        pMap.put("mem_pw", "123");
        pMap.put("mem_gender", "여자");
        list.add(pMap);

        pMap = new HashMap<>();
        pMap.put("mem_id", "kiwi");
        pMap.put("mem_name", "키위");
        pMap.put("mem_pw", "123");
        pMap.put("mem_gender", "남자");
        list.add(pMap);

        System.out.println(pMap.keySet());
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> tMap = list.get(i);
            // System.out.println(tMap.get("mem_id"));
            System.out.println(tMap.values());
        }
    }
}
