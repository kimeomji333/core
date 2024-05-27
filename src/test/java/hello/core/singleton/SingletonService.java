package hello.core.singleton;

// 싱글톤 패턴을 적용한 예제 코드
// JVM 자바가 뜰 때 싱클톤서비스 클래스를 스태틱 영역에 new 이하를 실행해서 객체를 생성한 다음 변수에 참조함.
public class SingletonService {

    // 1. static 영역에 객체를 딱 1개만 생성해서 변수에 참조함.
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회 허용
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. 생성자를 private 선언해서 외부에 new 를 사용한 객체 생성 못하게 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
