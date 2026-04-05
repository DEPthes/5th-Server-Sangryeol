package Runnable;

public class MyRunnable implements Runnable {

    // 스레드가 실행할 작업을 정의하는 메서드
    public void run() {
        // 1부터 5까지 반복하면서 출력
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable: " + i);
        }
    }

    public static void main(String[] args) {

        // Runnable 객체 생성 (실행할 작업 정의)
        MyRunnable runnable = new MyRunnable();

        // Thread 객체 생성하면서 Runnable 전달
        Thread thread = new Thread(runnable);

        // 스레드 시작 -> run() 메서드가 실행됨
        thread.start();
    }
}