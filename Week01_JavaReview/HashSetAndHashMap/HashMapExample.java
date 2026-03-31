package HashSetAndHashMap;

import java.util.HashMap;


public class HashMapExample {

    public static void main(String[] args) {

        // 문자열(String)을 Key로, 정수(Integer)를 Value로 저장하는 HashMap 생성
        HashMap<String, Integer> map = new HashMap<>();

        // 데이터 추가 (Key-Value 쌍으로 저장)
        map.put("철수", 100);
        map.put("영희", 90);

        // Key를 이용하여 해당하는 Value 조회 후 출력
        System.out.println(map.get("철수"));  // 100 출력
        System.out.println(map.get("영희"));  // 90 출력
    }
}
