package HashSetAndHashMap;

import java.util.HashSet;

public class HashSetExample {

    public static void main(String[] args) {
        // 문자열(String)을 저장할 수 있는 HashSet 생성
        HashSet<String> set = new HashSet<>();

        // 데이터 추가
        set.add("철수");
        set.add("영희");
        set.add("철수");  // 중복 데이터 (저장되지 않음)

        // HashSet 출력 (중복이 제거된 상태로 출력됨)
        System.out.println(set);
    }
}
