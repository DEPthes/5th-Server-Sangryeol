package Synchronization;

class SharedData {
    public int data = 0;        // 여러 쓰레드가 공유하는 변수

    // 동기화 된 메서드 -> 한 번에 하나의 쓰레드만 접근 가능
    synchronized public void increment() {
        data++;     // 공유 데이터 증가
    }
}

public class SynchronizationExample {

    public static void main(String[] args) throws InterruptedException {

        SharedData sharedData = new SharedData();       // 공유 객체 생성

        // 첫 번째 쓰레드 생성
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedData.increment();     // 공유 데이터 증가
            }
        });

        // 두 번째 쓰레드 생성
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedData.increment();     // 공유 데이터 증가
            }
        });

        thread1.start();        // 쓰레드 실행
        thread2.start();

        thread1.join();         // thread1 종료까지 대기
        thread2.join();         // thread2 종료까지 대기

        // 최종 결과 출력
        System.out.println("SharedData: " + sharedData.data);
    }
}