import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Mischa Holz
 */


public class JavaTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = Test.Test1.class.getConstructor();
        constructor.setAccessible(true);

        Object instance = constructor.newInstance();
    }

    static abstract class Test {
        abstract String getTest();

        private Test() {
        }

        public Test(String marker) {
            this();
        }

        static class Test1 extends Test {
            String field;

            String getTest() {
                return field;
            }

            public Test1() {
                super();
            }

            public Test1(String field) {
                super(null);

                this.field = field;
            }
        }

    }
}
