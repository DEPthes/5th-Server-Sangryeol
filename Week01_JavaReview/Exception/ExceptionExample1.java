package Exception;

public class ExceptionExample1 {

    public static void main(String[] args) {

        // 정수 배열 생성
        int[] numbers = {1, 2, 3};

        int index = 5;  // 존재하지 않는 인덱스

        try {
            int result = numbers[index];                        // 배열의 index 위치 값 접근
            System.out.println("결과: " + result);               // 정상적으로 값이 있을 경우 출력
        } catch (ArrayIndexOutOfBoundsException e) {
            // 예외 발생 시 실행되는 부분
            System.out.println("문제 발생");
        }
    }
}