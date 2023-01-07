package hello.proxy.jdkdynamic;

import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ReflectionTest {

    static class Hello {

        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }

    @Test
    void reflection0() {
        Hello target = new Hello();

        log.info("start A");
        String resultA = target.callA();
        log.info("result A = {}", resultA);

        log.info("start B");
        String resultB = target.callB();
        log.info("result B = {}", resultB);
    }

    @Test
    void reflection1() throws Exception {
        //클래스 정보
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        //call 메서드 정보
        Method callA = classHello.getMethod("callA");
        Object resultA = callA.invoke(target);
        log.info("result A = {}", resultA);

        Method callB = classHello.getMethod("callB");
        Object resultB = callA.invoke(target);
        log.info("result B = {}", resultB);
    }



}
