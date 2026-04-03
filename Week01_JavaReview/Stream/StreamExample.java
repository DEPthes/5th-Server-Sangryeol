package Stream;

import java.util.Arrays;
import java.util.List;

public class StreamExample {

    public static void main(String[] args) {
        
        // 정수 (Integer) 리스트 생성
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 스트림 생성 후 데이터 처리
        numbers.stream()
                .filter(n -> n % 2 == 0)    // 짝수만 필터링
                .map(n -> n * 2)            // 각 요소 값을 2배로 변환
                .forEach(System.out::println);     // 결과 출력
    }
}