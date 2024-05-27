package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService service1 = ac.getBean(StatefulService.class);
        StatefulService service2 = ac.getBean(StatefulService.class);

        //ThreadA: A 사용자 10000원 주문
        int userAPrice = service1.order("userA", 10000);
        //ThreadB: B 사용자 20000원 주문
        int userBPrice = service2.order("userB", 20000);

        // ThreadA: A 사용자 주문 금액 조회
//        int price = service1.getPrice();
        System.out.println("userAPrice = " + userAPrice);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}