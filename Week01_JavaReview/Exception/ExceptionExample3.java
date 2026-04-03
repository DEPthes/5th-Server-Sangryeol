package Exception;

public class ExceptionExample3 {

    public static void main(String[] args) {
        try {
            int result = 3 / 0;     // 0으로 나누기 실패
        } catch (Exception e) {
            System.out.println("문제 발생");        // 예외 발생 시 실행
        } finally {
            System.out.println("실행 종료");        // 예외 발생 여부와 관계 없이 항상 실행
        }

        try {
            int result = 4 / 2;     // 나누기 성공
        } catch (Exception e) {
            System.out.println("문제 발생");        // 예외가 발생하지 않으면 실행되지 않음
        } finally {
            System.out.println("실행 종료");        // 예외가 없어도 항상 실행
        }
    }
}