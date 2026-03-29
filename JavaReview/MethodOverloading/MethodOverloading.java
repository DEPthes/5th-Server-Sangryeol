package MethodOverloading;

public class MethodOverloading {

    public static int add(int a, int b) {
        // 정수 2개를 전달받아 두 값을 더한 결과를 반환하는 메서드
        return a + b;
    }

    public static int add(int a, int b, int c) {
        // 정수 3개를 전달받아 세 값을 모두 더한 결과를 반환하는 메서드
        return a + b + c;
    }

    public static double add (double a, double b) {
        // 실수 2개를 전달받아 두 값을 더한 결과를 반환하는 메서드
        return a + b;
    }

    /* 위 세 메서드는 모두 이름이 add로 동일하지만,
    매개변수의 개수와 타입이 다르기 때문에 서로 다른 메서드로 인식된다.
    이를 메서드 오버로딩이라고 한다. */

    public static void main(String[] args) {
        // 정수 2개를 전달 → add(int a, int b) 메서드 호출
        System.out.println(add(1,2));

        // 정수 3개를 전달 → add(int a, int b, int c) 메서드 호출
        System.out.println(add(1,2,3));

        // 실수 2개를 전달 → add(double a, double b) 메서드 호출
        System.out.println(add(5.3, 3.8));
    }

    /* 전달되는 값의 개수와 타입에 따라 서로 다른 add 메서드가 호출된다.
    이를 통해 하나의 메서드 이름으로 다양한 경우를 처리할 수 있다. */
}
