import org.junit.jupiter.api.Test;

import java.util.List;

public class AnotherClass {
    @Test
    void test() {
        TestMainExample testMain = new TestMainExample();

        System.out.println(testMain.hi);
        testMain.printTest1();
    }
    public static  String getHi() {
        return "Hi";
    }
    public static String capital(String text) {
        return text.toUpperCase();
    }
    public static String[] getWords() {
        String[] result = {"first", "second"};
        return result;
    }
    public static List<String> getBerries() {
        return List.of("redberry", "blackberry");
    }
}
