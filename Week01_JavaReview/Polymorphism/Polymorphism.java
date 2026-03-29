package Polymorphism;

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

public class Polymorphism {
    public static void main(String[] args) {
        /* 두 객체 모두 Person이라는 동일한 참조변수 타입을 사용함
           하지만 실제로 참조하고 있는 객체의 타입은 다름
           따라서 실행 시 "사람입니다."와 "학생입니다."가 각각 정상적으로 출력되는 것을 확인할 수 있음
         */
        Person person = new Person();
        Person student = new Student();
        person.introduce();
        student.introduce();
    }
}
