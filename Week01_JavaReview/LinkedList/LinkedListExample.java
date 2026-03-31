package LinkedList;

import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {
        // 문자열을 저장할 수 있는 LinkedList 생성
        LinkedList<String> list = new LinkedList<>();

        // 리스트에 데이터 추가
        list.add("철수");
        list.add("영희");

        // for문을 사용하여 리스트의 모든 요소를 순회
        for (String s: list) {
            // 각 요소를 하나씩 출력
            System.out.println(s);
        }
    }
}