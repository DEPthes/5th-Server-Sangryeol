package Thread;

class MyThread extends Thread {

    public void run() {

        // 쓰레드가 실행할 작업 내용
        // 1부터 5까지 반복하면서 출력
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + i);
        }
    }
}

public class ThreadExample {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
