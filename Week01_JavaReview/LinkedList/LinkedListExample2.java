package LinkedList;

import java.util.LinkedList;

public class LinkedListExample2 {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("철수");
        list.add("영희");

        // 배열 요소들 출력
        for(String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        // 배열의 2번째(인덱스 1) 값 출력
        System.out.println(list.get(1));

        // 배열의 첫 번째 값 출력
        System.out.println(list.getFirst());

        // 배열의 마지막 값 출력
        System.out.println(list.getLast());

        // 배열의 처음에 "영철"이라는 문자열 추가
        list.addFirst("영철");

        for(String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        // 배열의 마지막에 "민서"라는 문자열 추가
        list.addLast("민서");

        // 배열 요소들 출력
        for(String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        // 리스트의 2번째(인덱스 1)에 "준서"라는 문자열 삽입, 이후 값들은 뒤로 밀려남
        list.add(1, "준서");

        // 베열 요소들 출력
        for(String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
