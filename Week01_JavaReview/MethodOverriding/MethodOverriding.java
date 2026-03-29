package MethodOverriding;

// 사람을 표현하는 부모 클래스
class Person {
    public void introduce() {
        System.out.println("사람입니다.");
    }
}

// Person 클래스를 상속 받은 자식 클래스
class Student extends Person {
    // 부모 클래스의 introduce() 메서드를 재정의 (오버라이딩)
    public void introduce() {
        System.out.println("학생입니다.");
    }
}
public class MethodOverriding {
    public static void main(String[] args) {
        // Student 객체에서 introduce() 메서드 호출 시 부모 클래스의 메서드가 아닌 "학생입니다."라는 문장이 출력됨
        Student student = new Student();
        student.introduce();
    }
}
