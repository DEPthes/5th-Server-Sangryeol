package Exception;

public class ExceptionExample2 {

    public static void main(String[] args) {
        try {
            int age = -5;                       // 나이를 음수로 설정

            // 나이가 음수인 경우 예외를 직접 발생시킴
            if (age < 0) {
                throw new Exception("나이는 음수일 수 없습니다.");
            }
        } catch (Exception e) {
            // 발생한 예외의 메시지를 출력
            System.out.println(e.getMessage());
        }
    }
}